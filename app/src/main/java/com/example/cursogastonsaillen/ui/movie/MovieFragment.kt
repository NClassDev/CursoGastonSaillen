package com.example.cursogastonsaillen.ui.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import com.example.cursogastonsaillen.R
import com.example.cursogastonsaillen.core.Resource
import com.example.cursogastonsaillen.data.model.Movie
import com.example.cursogastonsaillen.data.remote.MovieDataSource
import com.example.cursogastonsaillen.databinding.FragmentMovieBinding
import com.example.cursogastonsaillen.presentation.MovieViewModel
import com.example.cursogastonsaillen.presentation.MovieViewModelFactory
import com.example.cursogastonsaillen.presentation.ProfileViewModel
import com.example.cursogastonsaillen.repository.MovieRepositoryImpl
import com.example.cursogastonsaillen.repository.RetrofitClient
import com.example.cursogastonsaillen.ui.movie.adapters.MovieAdapter
import com.example.cursogastonsaillen.ui.movie.adapters.concat.PopularConcatAdapter
import com.example.cursogastonsaillen.ui.movie.adapters.concat.TopRatedConcatAdapter
import com.example.cursogastonsaillen.ui.movie.adapters.concat.UpcomingConcatAdapter

class MovieFragment : Fragment(R.layout.fragment_movie), MovieAdapter.OnMovieClickListener {

    private lateinit var binding: FragmentMovieBinding

     // ViewModel with manual dependency injection
    private val viewModel by viewModels<MovieViewModel> {
        MovieViewModelFactory(MovieRepositoryImpl(MovieDataSource(RetrofitClient.webservice)))
    }

    private val profileViewModel : ProfileViewModel by activityViewModels()

    private lateinit var concatAdapter: ConcatAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieBinding.bind(view)

        concatAdapter = ConcatAdapter()

        viewModel.fetchMainScreenMovies().observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                    binding.progressVar.visibility = View.GONE

                }
                is Resource.Success -> {
                    binding.progressVar.visibility = View.VISIBLE
                    concatAdapter.apply {
                        addAdapter(
                            0,
                            UpcomingConcatAdapter(
                                MovieAdapter(
                                    result.data.first.results,
                                    this@MovieFragment
                                )
                            )
                        )
                        addAdapter(
                            0,
                            TopRatedConcatAdapter(
                                MovieAdapter(
                                    result.data.second.results,
                                    this@MovieFragment
                                )
                            )
                        )
                        addAdapter(
                            0,
                            PopularConcatAdapter(
                                MovieAdapter(
                                    result.data.third.results,
                                    this@MovieFragment
                                )
                            )
                        )
                    }
                    binding.rvMovies.adapter = concatAdapter
                }
                is Resource.Failure -> {
                    binding.progressVar.visibility = View.GONE
                }
            }
        })

        // Setting a LiveData using navigationComponents
        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<String>("movie")?.observe(
            viewLifecycleOwner) {
            Log.d("MovieFragment", it)
        }

        binding.apply {
            floatingBtnViewProfile.visibility = if(profileViewModel.getCurrentMovie().value != "") View.VISIBLE else View.GONE

            floatingBtnViewProfile.setOnClickListener {
                val action = MovieFragmentDirections.actionMovieFragmentToProfileFragment()
                findNavController().navigate(action)
            }
        }

    }

    override fun onMovieClick(movie: Movie) {
        val action = MovieFragmentDirections.actionMovieFragmentToMovieDatailFragment(
            movie.poster_path,
            movie.vote_average.toFloat().toString(),
            movie.title,
            movie.backdrop_path,
            movie.original_language,
            movie.overview,
            movie.release_date
        )

        profileViewModel.setCurrentMovie(movie.title)

        findNavController().navigate(action)
    }

}
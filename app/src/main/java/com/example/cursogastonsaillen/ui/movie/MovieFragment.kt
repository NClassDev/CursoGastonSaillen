package com.example.cursogastonsaillen.ui.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ConcatAdapter
import com.example.cursogastonsaillen.R
import com.example.cursogastonsaillen.core.Resource
import com.example.cursogastonsaillen.data.model.Movie
import com.example.cursogastonsaillen.data.remote.MovieDataSource
import com.example.cursogastonsaillen.databinding.FragmentMovieBinding
import com.example.cursogastonsaillen.presentation.MovieViewModel
import com.example.cursogastonsaillen.presentation.MovieViewModelFactory
import com.example.cursogastonsaillen.repository.MovieRepositoryImpl
import com.example.cursogastonsaillen.repository.RetrofitClient
import com.example.cursogastonsaillen.ui.movie.adapters.MovieAdapter
import com.example.cursogastonsaillen.ui.movie.adapters.concat.PopularConcatAdapter
import com.example.cursogastonsaillen.ui.movie.adapters.concat.TopRatedConcatAdapter
import com.example.cursogastonsaillen.ui.movie.adapters.concat.UpcomingConcatAdapter

class MovieFragment : Fragment(R.layout.fragment_movie), MovieAdapter.OnMovieClickListener {

    private lateinit var binding: FragmentMovieBinding

    private val viewModel by viewModels<MovieViewModel> {
        MovieViewModelFactory(MovieRepositoryImpl(MovieDataSource(RetrofitClient.webservice)))
    }

    private lateinit var concatAdapter: ConcatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

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
                        addAdapter(0, UpcomingConcatAdapter(MovieAdapter(result.data.first.results, this@MovieFragment)))
                        addAdapter(0, TopRatedConcatAdapter(MovieAdapter(result.data.second.results, this@MovieFragment)))
                        addAdapter(0, PopularConcatAdapter(MovieAdapter(result.data.third.results, this@MovieFragment)))
                    }


                    binding.rvMovies.adapter = concatAdapter
                }
                is Resource.Failure -> {
                    binding.progressVar.visibility = View.GONE
                }
            }
        })

    }

    override fun onMovieClick(movie: Movie) {
        Log.d("Movie", "onMovieClick: $movie")
    }

}
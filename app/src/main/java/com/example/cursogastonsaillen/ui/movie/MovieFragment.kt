package com.example.cursogastonsaillen.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import com.example.cursogastonsaillen.R
import com.example.cursogastonsaillen.data.remote.MovieDataSource
import com.example.cursogastonsaillen.databinding.FragmentMovieBinding
import com.example.cursogastonsaillen.presentation.MovieViewModel
import com.example.cursogastonsaillen.presentation.MovieViewModelFactory
import com.example.cursogastonsaillen.repository.MovieRepository
import com.example.cursogastonsaillen.repository.MovieRepositoryImpl
import com.example.cursogastonsaillen.repository.RetrofitClient

class MovieFragment : Fragment(R.layout.fragment_movie) {

    private lateinit var binding: FragmentMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieBinding.bind(view)
    }

}
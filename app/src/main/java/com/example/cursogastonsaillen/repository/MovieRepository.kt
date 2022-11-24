package com.example.cursogastonsaillen.repository

import com.example.cursogastonsaillen.data.model.MovieList

interface MovieRepository {
    suspend fun getUpcomingMovies() : MovieList
    suspend fun getTopRateMovies() : MovieList
    suspend fun getPopularMovies() : MovieList
}
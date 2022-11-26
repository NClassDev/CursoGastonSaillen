package com.example.cursogastonsaillen.repository

import com.example.cursogastonsaillen.data.model.MovieList
import com.example.cursogastonsaillen.data.remote.MovieDataSource

class MovieRepositoryImpl(private val dataSource: MovieDataSource) : MovieRepository {
    override suspend fun getUpcomingMovies(): MovieList = dataSource.getUpComingMovies()
    override suspend fun getTopRateMovies(): MovieList = dataSource.getTopRatedMovies()
    override suspend fun getPopularMovies(): MovieList = dataSource.getPopularMovies()
}
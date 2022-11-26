package com.example.cursogastonsaillen.data.remote

import com.example.cursogastonsaillen.application.AppConstants
import com.example.cursogastonsaillen.data.model.MovieList
import com.example.cursogastonsaillen.repository.WebService

class MovieDataSource(private val webService: WebService) {

    suspend fun getUpComingMovies(): MovieList = webService.getUpcomingMovies(AppConstants.API_KEY)

    suspend fun getTopRatedMovies(): MovieList = webService.getTopRateMovies(AppConstants.API_KEY)

    suspend fun getPopularMovies(): MovieList = webService.getPopularMovies(AppConstants.API_KEY)

}
package com.example.cursogastonsaillen.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel: ViewModel() {

    val currentMovie = MutableLiveData<String>()

    fun setCurrentMovie(movie: String) {
        currentMovie.value = movie
    }

    fun getCurrentMovie(): LiveData<String> {
        return currentMovie
    }
}
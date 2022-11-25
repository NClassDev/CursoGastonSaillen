package com.example.cursogastonsaillen.presentation

import androidx.lifecycle.*
import com.example.cursogastonsaillen.core.Resource
import com.example.cursogastonsaillen.repository.MovieRepository
import kotlinx.coroutines.Dispatchers

class MovieViewModel(private val repo: MovieRepository) : ViewModel() {

    fun fetchMainScreenMovies() = liveData(viewModelScope.coroutineContext + Dispatchers.Main) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(Triple(repo.getPopularMovies(), repo.getTopRateMovies(), repo.getUpcomingMovies())))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

}

class MovieViewModelFactory(private val repo: MovieRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(MovieRepository::class.java).newInstance(repo)
    }
}
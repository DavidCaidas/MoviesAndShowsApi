package com.movies.movies_and_shows_api.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movies.movies_and_shows_api.domain.GetMoviesFeedUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesFeedViewModel (private val getMoviesFeedUseCase: GetMoviesFeedUseCase) : ViewModel(){

    val moviesFeedPublisher:MutableLiveData<MoviesUiState> by lazy{
        MutableLiveData<MoviesUiState>()
    }

    fun loadMovies(){
        moviesFeedPublisher.value = MoviesUiState(true)

        viewModelScope.launch(Dispatchers.IO) {
            val moviesFeedList = getMoviesFeedUseCase.execute()
            moviesFeedPublisher.postValue(
                MoviesUiState(
                    isLoading = false,
                    moviesFeed = moviesFeedList
                )
            )
        }
    }

    data class MoviesUiState(
        val isLoading:Boolean = false,
        val moviesFeed: List<GetMoviesFeedUseCase.MovieFeed> = emptyList()
    )

}
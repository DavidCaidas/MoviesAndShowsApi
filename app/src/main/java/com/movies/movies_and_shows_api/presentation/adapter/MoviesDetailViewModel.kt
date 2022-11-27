package com.movies.movies_and_shows_api.presentation.adapter


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movies.movies_and_shows_api.domain.GetMovieDetailUseCase
import com.movies.movies_and_shows_api.domain.GetMoviesFeedUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesDetailViewModel (private val getMovieDetailUseCase: GetMovieDetailUseCase) : ViewModel(){

    val moviesDetailPublisher: MutableLiveData<MovieUiState> by lazy{
        MutableLiveData<MovieUiState>()
    }

    fun loadDetailMovie(id:String){
        moviesDetailPublisher.value = MovieUiState(true)

        viewModelScope.launch(Dispatchers.IO) {
            val singleMovie = getMovieDetailUseCase.execute(id)
            moviesDetailPublisher.postValue(
                MovieUiState(
                    isLoading = false,
                    movie = singleMovie
                )
            )
        }
    }

    data class MovieUiState(
        val isLoading:Boolean = false,
        val movie: GetMovieDetailUseCase.movieDetail? = null
    )

}
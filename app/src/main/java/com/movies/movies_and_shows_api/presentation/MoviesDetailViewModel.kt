package com.movies.movies_and_shows_api.presentation


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movies.movies_and_shows_api.domain.GetMovieDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesDetailViewModel(private val getMovieDetailUseCase: GetMovieDetailUseCase) :
    ViewModel() {

    val movieDetailState: MutableLiveData<MovieDetailState> by lazy {
        MutableLiveData<MovieDetailState>()
    }

    fun loadDetailMovie(movieId: String){
        movieDetailState.value = MovieDetailState()
        viewModelScope.launch (Dispatchers.IO) {
            getMovieDetailUseCase.execute(movieId).apply {
                movieDetailState.postValue(MovieDetailState(this))
            }
        }
    }



    data class MovieDetailState(
        val movieDetail: GetMovieDetailUseCase.movieDetail? = null
    )

}
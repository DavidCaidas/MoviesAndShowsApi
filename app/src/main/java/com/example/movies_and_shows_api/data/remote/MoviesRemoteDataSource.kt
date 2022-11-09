package com.example.movies_and_shows_api.data.remote


import com.example.movies_and_shows_api.domain.movie



interface MoviesRemoteDataSource {
    fun getmovies(): List<movie>
    fun getmovie(movieId: String): movie?
}
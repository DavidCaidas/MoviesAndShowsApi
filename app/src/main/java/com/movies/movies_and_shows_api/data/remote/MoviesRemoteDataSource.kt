package com.movies.movies_and_shows_api.data.remote


import com.movies.movies_and_shows_api.domain.Movie


interface MoviesRemoteDataSource {
    fun getMovies(): List<Movie>
    fun getMovie(movieId: String): Movie?
}


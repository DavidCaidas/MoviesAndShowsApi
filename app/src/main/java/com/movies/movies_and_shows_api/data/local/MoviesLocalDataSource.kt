package com.movies.movies_and_shows_api.data.local

import com.movies.movies_and_shows_api.domain.Movie

interface MoviesLocalDataSource {
    fun getAllMovies(): List<Movie>
    fun getMovieById(id: String): Movie?
    fun save(list: List<Movie>)
}
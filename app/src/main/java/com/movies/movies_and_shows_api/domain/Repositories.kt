package com.movies.movies_and_shows_api.domain

interface MovieRepository {
        fun getMovie(): List<Movie>
        fun getMovieById(movieId: String): Movie?
    }

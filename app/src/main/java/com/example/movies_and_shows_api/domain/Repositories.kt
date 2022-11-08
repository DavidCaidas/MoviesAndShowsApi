package com.example.movies_and_shows_api.domain

interface MovieRepository {
        fun getMovie(): List<movie>
        fun getMovieById(MovieId: String): movie?
    }

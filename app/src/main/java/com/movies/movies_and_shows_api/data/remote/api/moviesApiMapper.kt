package com.movies.movies_and_shows_api.data.remote.api

import com.movies.movies_and_shows_api.domain.Movie

fun moviesApiModel.toDomain(): Movie {

    return Movie(
        this.id, this.title, this.plot, this.genre, this.rating, this.year, this.poster
    )
}
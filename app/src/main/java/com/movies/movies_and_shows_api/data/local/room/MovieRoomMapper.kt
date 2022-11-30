package com.movies.movies_and_shows_api.data.local.room

import com.movies.movies_and_shows_api.domain.Movie

fun MoviesEntity.toDomain(): Movie {
    return Movie(
        this.id, this.title, this.plot, this.genre, this.rating, this.year, this.poster
    )
}

fun Movie.toEntity(): MoviesEntity {
    return MoviesEntity(
        this.id, this.title, this.plot, this.genre, this.rating, this.year, this.poster
    )
}
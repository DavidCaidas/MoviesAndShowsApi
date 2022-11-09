package com.example.movies_and_shows_api.data.remote.api



import com.example.movies_and_shows_api.domain.movie

fun moviesApiModel.toDomain(): movie {

    return movie(
        this.id, this.title,this.plot,this.genre,this.rating,this.year,this.poster)
}
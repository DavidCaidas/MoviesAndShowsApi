package com.movies.movies_and_shows_api.domain

class GetMoviesFeedUseCase(

    private val MovieRepository: MovieRepository


) {
    fun execute(): List<MovieFeed> {
        val movies = MovieRepository.getMovie()

        val list = movies.map { Movie ->

            MovieFeed(
                Movie.id, Movie.title, Movie.genre, Movie.rating, Movie.poster
            )
        }

        return list
    }

    data class MovieFeed(
        val id: String, val title: String, val genre: String, val rating: String, val poster: String
    )
}
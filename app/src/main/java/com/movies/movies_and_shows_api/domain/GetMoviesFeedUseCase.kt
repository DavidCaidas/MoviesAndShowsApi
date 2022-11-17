package com.movies.movies_and_shows_api.domain

class GetMoviesFeedUseCase (

    private val MovieRepository: MovieRepository = TODO()
){

    fun execute(): List<MovieFeed> {
        val movies = MovieRepository.getMovie()

        val list = movies.map { Movie ->

            MovieFeed(
                Movie.id,
                Movie.title,
                Movie.plot,
                Movie.genre,
                Movie.rating,
                Movie.year,
                Movie.poster
            )
        }

        return list
    }

    data class MovieFeed(
        val id: String,
        val title:String,
        val plot:String,
        val genre:String,
        val rating:String,
        val year:String,
        val poster:String
    )
}
package com.example.movies_and_shows_api.domain

class GetMoviesFeedUseCase (

    private val MovieRepository: MovieRepository = TODO()
){

    fun execute(): List<MovieFeed> {
        val movies = MovieRepository.getMovie()

        val list = movies.map { movie ->

            MovieFeed(
                movie.id,
                movie.title,
                movie.plot,
                movie.genre,
                movie.rating,
                movie.year,
                movie.Poster
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
        val Poster:String
    )
}
package com.movies.movies_and_shows_api.domain

class GetMovieDetailUseCase(
    private val movieRepository: MovieRepository,
) {

    fun execute(movieId: String): movieDetail {
        val movie = movieRepository.getMovieById(movieId)!!
        return movieDetail(

            movie.id, movie.title, movie.plot, movie.genre, movie.rating, movie.year, movie.poster
        )
    }

    data class movieDetail(

        val id: String,
        val title: String,
        val plot: String,
        val genre: String,
        val rating: String,
        val year: String,
        val poster: String
    )
}
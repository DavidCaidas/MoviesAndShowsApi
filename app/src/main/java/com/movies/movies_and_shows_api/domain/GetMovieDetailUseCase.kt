package com.movies.movies_and_shows_api.domain

class GetMovieDetailUseCase(
    private val movieRepository: MovieRepository,
) {

    fun execute(movieId: String): MovieDetail {
        val Movie = movieRepository.getMovieById(movieId)!!
        return MovieDetail(

            Movie.id,
            Movie.title,
            Movie.plot,
            Movie.genre,
            Movie.rating,
            Movie.year,
            Movie.poster
        )
    }

    data class MovieDetail(

        val id: String,
        val title: String,
        val plot: String,
        val genre: String,
        val rating: String,
        val year: String,
        val poster: String
    )
}
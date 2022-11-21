package com.movies.movies_and_shows_api.data

import com.movies.movies_and_shows_api.data.local.MoviesLocalDataSource
import com.movies.movies_and_shows_api.data.local.room.MovieDbLocalDataSource
import com.movies.movies_and_shows_api.domain.Movie
import com.movies.movies_and_shows_api.domain.MovieRepository

class MoviesDataRepository(
    val remoteSource: MovieDbLocalDataSource,
    val localSource: MoviesLocalDataSource
) :
    MovieRepository {

    override fun getMovie(): List<Movie> {
        var movies = localSource.getAllMovies()
        if (movies.isEmpty()) {
            movies = remoteSource.getAllMovies()
            if (movies.isNotEmpty()) {
                localSource.save(movies)
            }
        }
        return movies
    }

    override fun getMovieById(MovieId: String): Movie? {

        var movie = localSource.getMovieById(MovieId)
        if (movie == null) {
            movie = remoteSource.getMovieById(MovieId)
        }
        return movie
    }
}
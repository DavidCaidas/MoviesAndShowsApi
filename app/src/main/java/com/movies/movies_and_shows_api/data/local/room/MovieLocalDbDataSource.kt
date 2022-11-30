package com.movies.movies_and_shows_api.data.local.room


import com.movies.movies_and_shows_api.data.local.MoviesLocalDataSource
import com.movies.movies_and_shows_api.domain.Movie


class MovieDbLocalDataSource(private val daoMoviesDao: MoviesDao) : MoviesLocalDataSource {

    override fun getAllMovies(): List<Movie> {
        return daoMoviesDao.getAllMovies().map {
            it.toDomain()
        }
    }

    override fun getMovieById(id: String): Movie? {
        return daoMoviesDao.findMovieById(id)?.toDomain()
    }

    override fun save(list: List<Movie>) {
        val entities = list.map {
            it.toEntity()
        }
        daoMoviesDao.save(*entities.toTypedArray())
    }
}
package com.movies.movies_and_shows_api.data.local.mem

import com.movies.movies_and_shows_api.commons.MemoryDataStore
import com.movies.movies_and_shows_api.data.local.MoviesLocalDataSource
import com.movies.movies_and_shows_api.domain.Movie

class MoviesMemoryLocalDataSource (val memoryDataStore: MemoryDataStore<Movie>): MoviesLocalDataSource{

    override fun getAllMovies(): List<Movie> {
        return memoryDataStore.getAll()
    }

    override fun getMovieById(id: String): Movie? {
        return memoryDataStore.getById(id)
    }

    override fun save(list: List<Movie>) {
        list.forEach {
            memoryDataStore.put(it.id, it)
        }
    }

}
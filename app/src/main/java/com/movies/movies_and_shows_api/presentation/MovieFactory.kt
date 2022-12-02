package com.movies.movies_and_shows_api.presentation

import android.content.Context
import com.movies.movies_and_shows_api.data.ApiClient
import com.movies.movies_and_shows_api.data.MoviesDataRepository
import com.movies.movies_and_shows_api.data.local.room.MovieDbLocalDataSource
import com.movies.movies_and_shows_api.data.remote.api.MoviesApiRemoteDataSource
import com.movies.movies_and_shows_api.domain.GetMovieDetailUseCase
import com.movies.movies_and_shows_api.domain.GetMoviesFeedUseCase
import com.movies.movies_and_shows_api.presentation.adapter.MoviesDetailViewModel
import com.movies.movies_and_shows_api.roomDb.AppDatabase


class MovieFactory {

    fun getMoviesFeedViewModel(applicationContext: Context): MoviesFeedViewModel {
        return MoviesFeedViewModel(
            GetMoviesFeedUseCase(
                MoviesDataRepository(
                    MoviesApiRemoteDataSource(ApiClient()), MovieDbLocalDataSource(
                        AppDatabase.getDatabase(applicationContext).moviesDao(),
                    )

                )
            )
        )

    }

    fun getMoviesDetailViewModel(applicationContext: Context): MoviesDetailViewModel {
        return MoviesDetailViewModel(
            GetMovieDetailUseCase(
                MoviesDataRepository(
                    MoviesApiRemoteDataSource(ApiClient()), MovieDbLocalDataSource(
                        AppDatabase.getDatabase(applicationContext).moviesDao(),
                    )
                )
            )
        )
    }
}

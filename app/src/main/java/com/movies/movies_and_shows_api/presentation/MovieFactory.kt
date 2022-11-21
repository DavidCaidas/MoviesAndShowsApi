package com.movies.movies_and_shows_api.presentation

import android.content.Context
import android.content.SharedPreferences
import com.movies.movies_and_shows_api.commons.KSerializer
import com.movies.movies_and_shows_api.data.ApiClient
import com.movies.movies_and_shows_api.data.MoviesDataRepository
import com.movies.movies_and_shows_api.data.local.MoviesLocalDataSource
import com.movies.movies_and_shows_api.data.local.room.MovieDbLocalDataSource
import com.movies.movies_and_shows_api.data.local.room.MoviesDao
import com.movies.movies_and_shows_api.data.local.xml.MoviesXmlLocalDataSource
import com.movies.movies_and_shows_api.data.remote.MoviesRemoteDataSource
import com.movies.movies_and_shows_api.data.remote.api.MoviesApiRemoteDataSource
import com.movies.movies_and_shows_api.domain.GetMoviesFeedUseCase
import com.movies.movies_and_shows_api.roomDb.AppDatabase


class MovieFactory {

    fun getMoviesFeedViewModel(applicationContext: Context, serializer:KSerializer, sharedPreferences: SharedPreferences): MoviesFeedViewModel {
        return MoviesFeedViewModel(
            GetMoviesFeedUseCase(
                MoviesDataRepository(
                    MovieDbLocalDataSource(
                        AppDatabase.getDatabase(applicationContext).moviesDao()
                    ),
                    MoviesXmlLocalDataSource(
                        sharedPreferences,serializer
                    )
                )
            )
        )
    }
}

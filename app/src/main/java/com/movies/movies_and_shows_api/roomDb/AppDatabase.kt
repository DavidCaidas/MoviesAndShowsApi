package com.movies.movies_and_shows_api.roomDb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.movies.movies_and_shows_api.data.local.room.MoviesDao
import com.movies.movies_and_shows_api.data.local.room.MoviesEntity

@Database(entities = [MoviesEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun moviesDao(): MoviesDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(context, AppDatabase::class.java, "movies-room-db")
                            .build()
                }
            }
            return INSTANCE!!
        }
    }

}
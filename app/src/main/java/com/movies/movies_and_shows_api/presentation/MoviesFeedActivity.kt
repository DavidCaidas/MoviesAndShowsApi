package com.movies.movies_and_shows_api.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.movies_and_shows_api.databinding.ActivityMoviesFeedBinding


class MoviesFeedActivity : AppCompatActivity() {

    private var binding: ActivityMoviesFeedBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
    }

    fun setupBinding(){
        binding = ActivityMoviesFeedBinding.inflate(layoutInflater)
        binding?.let {
            setContentView(it.root)
        }
    }
}

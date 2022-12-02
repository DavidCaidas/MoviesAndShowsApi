package com.movies.movies_and_shows_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movies_and_shows_api.R
import com.example.movies_and_shows_api.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding?.let {
            setContentView(it.root)
        }
    }
}
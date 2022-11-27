package com.movies.movies_and_shows_api.extensions


import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadUrl(urlImage: String) {
    Glide.with(this).load(urlImage).into(this)
}
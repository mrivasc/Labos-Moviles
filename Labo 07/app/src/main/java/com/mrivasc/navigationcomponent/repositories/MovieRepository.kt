package com.mrivasc.navigationcomponent.repositories

import android.graphics.Movie
import com.mrivasc.navigationcomponent.data.model.MovieModel

class MovieRepository(private val movies: MutableList<MovieModel>) {
    fun getMovies() = movies

    fun addMovies(movie: MovieModel) = movies.add(movie)
}
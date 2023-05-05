package com.mrivasc.navigationcomponent

import android.app.Application
import com.mrivasc.navigationcomponent.data.movies
import com.mrivasc.navigationcomponent.repositories.MovieRepository

class MovieReviewerApplication : Application() {
    val movieRepository: MovieRepository by lazy {
        MovieRepository(movies)
    }
}
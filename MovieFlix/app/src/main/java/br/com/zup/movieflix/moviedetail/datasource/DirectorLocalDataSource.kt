package br.com.zup.movieflix.moviedetail.datasource

import android.app.Application
import android.content.Context
import br.com.zup.movieflix.*
import br.com.zup.movieflix.home.model.Movie
import br.com.zup.movieflix.moviedetail.model.DirectorModel


class DirectorLocalDataSource(private val application: Application) {
    fun getSharedPreferences(movie: Movie): Boolean {
        val preferences = application.getSharedPreferences(SAVED_MOVIE, Context.MODE_PRIVATE)
        return preferences.getBoolean(movie.title, false)
    }

    fun saveSharedPreferences(movie: Movie, isFavorite: Boolean) {
        application.getSharedPreferences(SAVED_MOVIE, Context.MODE_PRIVATE).edit().apply {
            putBoolean(movie.title, isFavorite)
            apply()
        }
    }

    val directorList = mutableListOf(
        DirectorModel(
            TARANTINO,
            TARANTINO_INFO
        ),
        DirectorModel(
            MARTIN_SCORSESE,
            MARTIN_SCORSESE_INFO
        )
    )
}
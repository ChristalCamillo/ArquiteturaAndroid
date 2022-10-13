package br.com.zup.movieflix.moviedetail.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.zup.movieflix.DIRECTOR_KEY
import br.com.zup.movieflix.MOVIE_NAME_KEY
import br.com.zup.movieflix.PREFERENCE_KEY
import br.com.zup.movieflix.SAVED_MOVIE
import br.com.zup.movieflix.home.model.Movie
import br.com.zup.movieflix.moviedetail.datasource.DirectorLocalDataSource
import br.com.zup.movieflix.moviedetail.model.DirectorWithFavoriteModel
import br.com.zup.movieflix.moviedetail.model.MovieWithDirectorAndFavoritesModel
import br.com.zup.movieflix.moviedetail.repository.MovieDetailRepository

class MovieDetailViewModel(application: Application) : AndroidViewModel(application) {
    private val repository  = MovieDetailRepository(DirectorLocalDataSource())
    private var _response : MutableLiveData<MovieWithDirectorAndFavoritesModel> = MutableLiveData()
    val response : LiveData<MovieWithDirectorAndFavoritesModel> = _response

    private val _savedData : MutableLiveData<DirectorWithFavoriteModel> = MutableLiveData()
    val savedData : LiveData<DirectorWithFavoriteModel> = _savedData

    private  val _savedDataFlag : MutableLiveData<Boolean> = MutableLiveData()
    val savedDataFlag : LiveData<Boolean> = _savedDataFlag

    private val pref = application.getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE)
    private val prefEditor = pref.edit()

    fun getSavedData(){
        try {
            val movieName = pref.getString(MOVIE_NAME_KEY, "").toString()
            val director = pref.getString(DIRECTOR_KEY, "").toString()
            val savedMovie = DirectorWithFavoriteModel(movieName, director)
            _savedData.value = savedMovie
            _savedDataFlag.value = pref.getBoolean(SAVED_MOVIE, false)
        }catch (e:Exception){
            Log.i("Error", "------> ${e.message}")
        }
    }

    fun favoriteMovie (movie : Movie, flagSaveData:Boolean){
        try {
            prefEditor.putBoolean(SAVED_MOVIE, flagSaveData)
            if(flagSaveData){
                prefEditor.putString(MOVIE_NAME_KEY, movie.title)
                prefEditor.putString(DIRECTOR_KEY, movie.director)
                prefEditor.apply()
            }else{
                prefEditor.remove(MOVIE_NAME_KEY)
                prefEditor.remove(DIRECTOR_KEY)
                prefEditor.apply()
            }
            _response.value = repository.getMovieWithDirector(movie)
        }catch (ex: Exception){
            Log.i("Error", "------> ${ex.message}")
        }

    }

    fun getMovieWithDirector(movie: Movie){
        try {
            _response.value = repository.getMovieWithDirector(movie)
        }catch (e:Exception){
            Log.e("Erro", e.message.toString())
        }
    }
}
package br.com.zup.movieflix.moviedetail.repository

import br.com.zup.movieflix.home.model.Movie
import br.com.zup.movieflix.moviedetail.datasource.DirectorLocalDataSource
import br.com.zup.movieflix.moviedetail.model.DirectorWithFavoriteModel
import br.com.zup.movieflix.moviedetail.model.MovieWithDirectorAndFavoritesModel

class MovieDetailRepository (private val dataSource: DirectorLocalDataSource) {

    fun getMovieWithDirector(movie: Movie) : MovieWithDirectorAndFavoritesModel{
        val listaDeDiretores = dataSource.directorList
        var diretor = DirectorWithFavoriteModel("","")
        listaDeDiretores.forEach {
            if(it.name == movie.director){
                diretor = it
            }
        }
        return MovieWithDirectorAndFavoritesModel(diretor,movie)
    }
}
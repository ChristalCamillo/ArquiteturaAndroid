package br.com.zup.movieflix.moviedetail.model

import br.com.zup.movieflix.home.model.Movie

data class MovieWithDirectorAndFavoritesModel(
    val director : DirectorWithFavoriteModel,
    val movie : Movie,
    var favorite : Boolean = false
)

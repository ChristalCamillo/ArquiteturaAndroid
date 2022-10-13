package br.com.zup.movieflix.moviedetail.datasource

import br.com.zup.movieflix.MARTIN_SCORSESE
import br.com.zup.movieflix.MARTIN_SCORSESE_INFO
import br.com.zup.movieflix.TARANTINO
import br.com.zup.movieflix.TARANTINO_INFO
import br.com.zup.movieflix.moviedetail.model.DirectorWithFavoriteModel


class DirectorLocalDataSource {
    val directorList = mutableListOf(
        DirectorWithFavoriteModel(
            TARANTINO,
            TARANTINO_INFO
        ),
        DirectorWithFavoriteModel(
            MARTIN_SCORSESE,
            MARTIN_SCORSESE_INFO
        )
    )
}
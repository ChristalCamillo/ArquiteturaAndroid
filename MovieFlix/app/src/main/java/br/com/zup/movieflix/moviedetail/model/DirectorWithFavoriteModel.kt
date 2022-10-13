package br.com.zup.movieflix.moviedetail.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DirectorWithFavoriteModel(
    var name: String,
    var info: String,
    var favorite: Boolean = false
) : Parcelable
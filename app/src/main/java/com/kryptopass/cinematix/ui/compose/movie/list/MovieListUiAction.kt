package com.kryptopass.cinematix.ui.compose.movie.list

import com.kryptopass.common.state.UiAction

// NOTE: concrete UiAction specific for Launch
sealed class MovieListUiAction : UiAction {

    data object Load : MovieListUiAction()

    //Add all values that you want to display on the details screen
    data class OnMovieItemClick(
        val movieId: Int?,
        val originalTitle:String?,
        val overview:String?,
        val posterPath:String?,
        val releaseDate:String?) : MovieListUiAction()
}
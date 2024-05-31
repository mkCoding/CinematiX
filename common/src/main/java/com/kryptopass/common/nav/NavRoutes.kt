package com.kryptopass.common.nav

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class NavRoutes(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {
    data object Movies : NavRoutes(ROUTE_MOVIES)

    //rout to Movies List
    data object Movie : NavRoutes(
//        route = String.format(ROUTE_MOVIE, "{$ARG_MOVIE_ID}"),
                 route = "movies/{$ARG_MOVIE_ID}?${ARG_ORIGIN_TITLE}={${ARG_ORIGIN_TITLE}}&${ARG_OVERVIEW}={${ARG_OVERVIEW}}&${ARG_IMAGE}={${ARG_IMAGE}}&${ARG_RELEASE_DATE}={${ARG_RELEASE_DATE}}",
        arguments = listOf(
            navArgument(ARG_MOVIE_ID) { type = NavType.IntType },
            navArgument(ARG_ORIGIN_TITLE){type = NavType.StringType},
            navArgument(ARG_OVERVIEW){type = NavType.StringType},
            navArgument(ARG_IMAGE) {type = NavType.StringType},
            navArgument(ARG_RELEASE_DATE) {type= NavType.StringType}

        ))

    {

        //rout to Movie Details
        fun routeForMovie(input: MovieInput) =
            "movies/${input.movieId}?${ARG_ORIGIN_TITLE}=${input.originalTitle}&${ARG_IMAGE}=${input.posterPath}&${ARG_OVERVIEW}=${input.overview}&${ARG_RELEASE_DATE}=${input.releaseDate}"
        fun fromEntry(entry: NavBackStackEntry): MovieInput {
            return MovieInput(
                entry.arguments?.getInt(ARG_MOVIE_ID) ?: 0,
                entry.arguments?.getString(ARG_ORIGIN_TITLE) ?: "",
                entry.arguments?.getString(ARG_OVERVIEW) ?: "",
                entry.arguments?.getString(ARG_IMAGE)?:"",
                entry.arguments?.getString(ARG_RELEASE_DATE)?:""

            )
        }
    }

    data object Search : NavRoutes(ROUTE_SEARCH)
    data object Login : NavRoutes(ROUTE_LOGIN)
    data object SignUp : NavRoutes(ROUTE_SIGN_UP)

    companion object {
        const val ROUTE_MOVIES = "movies"
        const val ROUTE_MOVIE = "movies/%s"
        const val ROUTE_SEARCH = "search"
        const val ARG_MOVIE_ID = "movieId"
        const val ARG_OVERVIEW = "overview"
        const val ARG_ORIGIN_TITLE="originalTitle"
        const val ARG_IMAGE = "posterPath"
        const val ARG_RELEASE_DATE="releaseDate"
        const val ROUTE_LOGIN = "login"
        const val ROUTE_SIGN_UP = "signup"
    }
}
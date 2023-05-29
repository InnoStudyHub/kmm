package com.seytkalievm.studyhub.android.presentation.util

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home_screen")
    object AuthScreen : Screen("auth_screen")
    object DeckViewScreen : Screen("deck_view_screen")
    object LoadingScreen : Screen("loading_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
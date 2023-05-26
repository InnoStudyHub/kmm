package com.seytkalievm.studyhub.android.presentation.util

sealed class Screen(val route: String) {
    object HomeScreen: Screen("home_screen")
    object AuthScreen: Screen("auth_screen")
    object DeckViewScreen: Screen("deck_view_screen")
    object LoadingScreen: Screen("loading_screen")
}
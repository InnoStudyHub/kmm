package com.seytkalievm.studyhub.android.util

sealed class Screen(val route: String) {
    object HomeScreen: Screen("home_screen")
}
package com.seytkalievm.studyhub.android.presentation.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.seytkalievm.studyhub.android.presentation.auth.login.LoginScreen
import com.seytkalievm.studyhub.android.presentation.session.HomeScreen


@Composable
fun Navigation () {
    val navController = rememberNavController()
    val isLoggedIn = true
    val startDest = if (isLoggedIn) Screen.HomeScreen.route else Screen.AuthScreen.route

    NavHost(navController = navController, startDestination = startDest) {
        if (isLoggedIn) {
            composable(Screen.HomeScreen.route) {
                HomeScreen()
            }
        } else {
            composable(Screen.AuthScreen.route) {
                LoginScreen(navController)
            }
        }
    }
}
package com.seytkalievm.studyhub.android.presentation.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.seytkalievm.studyhub.android.presentation.auth.login.LoginScreen
import com.seytkalievm.studyhub.android.presentation.session.MainScreen


@Composable
fun Navigation(
    viewModel: NavigationViewModel = hiltViewModel()
) {
    val navController = rememberNavController()
    val startDest = Screen.LoadingScreen.route
    val loggedState by viewModel.loggedState.collectAsState(initial = LoggedState.Loading)


    NavHost(navController = navController, startDestination = startDest) {
        composable(Screen.AuthScreen.route) { LoginScreen() }
        composable(Screen.LoadingScreen.route) { LoadingScreen() }
        composable(Screen.HomeScreen.route) { MainScreen() }
    }

    LaunchedEffect(loggedState) {
        when (loggedState) {
            LoggedState.Loading -> navController.navigate(Screen.LoadingScreen.route)

            LoggedState.LoggedIn -> navController.navigate(Screen.HomeScreen.route) {
                 this.popUpTo(Screen.HomeScreen.route)
            }

            LoggedState.NotLoggedIn -> navController.navigate(Screen.AuthScreen.route) {
                popUpTo(Screen.LoadingScreen.route)
            }
        }
    }
}
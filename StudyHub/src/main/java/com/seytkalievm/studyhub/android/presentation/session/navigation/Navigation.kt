package com.seytkalievm.studyhub.android.presentation.session.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.seytkalievm.studyhub.android.presentation.session.home.HomePage
import com.seytkalievm.studyhub.android.presentation.session.navigation.nav_bar.NavigationItem
import com.seytkalievm.studyhub.android.presentation.session.profile.ProfilePage
import com.seytkalievm.studyhub.android.presentation.session.search.SearchPage


@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            HomePage()
        }
        composable(NavigationItem.Search.route) {
            SearchPage()
        }
        composable(NavigationItem.Profile.route) {
            ProfilePage()
        }
    }
}
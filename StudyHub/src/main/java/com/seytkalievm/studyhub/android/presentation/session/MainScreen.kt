package com.seytkalievm.studyhub.android.presentation.session

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.seytkalievm.studyhub.android.presentation.session.home.HomePage
import com.seytkalievm.studyhub.android.presentation.session.navigation.nav_bar.BottomNavBar
import com.seytkalievm.studyhub.android.presentation.session.navigation.nav_bar.NavigationItem
import com.seytkalievm.studyhub.android.presentation.session.profile.ProfilePage
import com.seytkalievm.studyhub.android.presentation.session.search.SearchPage


@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Home", fontSize = 18.sp) }) },
        bottomBar = { BottomNavBar(navController) }
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            Navigation(navController = navController)
        }
    }
}

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
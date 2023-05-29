package com.seytkalievm.studyhub.android.presentation.session.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.seytkalievm.studyhub.android.presentation.auth.login.LoginScreen
import com.seytkalievm.studyhub.android.presentation.session.deck_view.DeckViewPage
import com.seytkalievm.studyhub.android.presentation.session.home.HomePage
import com.seytkalievm.studyhub.android.presentation.session.navigation.nav_bar.NavigationItem
import com.seytkalievm.studyhub.android.presentation.session.profile.ProfilePage
import com.seytkalievm.studyhub.android.presentation.session.search.SearchPage
import com.seytkalievm.studyhub.android.presentation.util.Screen
import com.seytkalievm.studyhub.android.presentation.util.fromJson
import com.seytkalievm.studyhub.domain.model.Deck


@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            HomePage(navController)
        }
        composable(NavigationItem.Search.route) {
            SearchPage()
        }
        composable(NavigationItem.Profile.route) {
            ProfilePage(navController)
        }
        composable(Screen.DeckViewScreen.route + "/{deck}",
            arguments = listOf(navArgument("deck") {
                type = NavType.StringType
            })) { entry ->
            entry.arguments?.getString("deck")?.let { jsonString ->
                val deck = jsonString.fromJson(Deck::class.java)
                DeckViewPage(deck = deck)
            }


        }
        //TODO should implement nested navControllers
        composable(Screen.AuthScreen.route) {
            LoginScreen(navController)
        }
    }
}
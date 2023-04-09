package com.seytkalievm.studyhub.android.presentation.session.navigation.nav_bar

import com.seytkalievm.studyhub.android.R

sealed class NavigationItem(val route: String, val icon: Int, val title: String) {
    object Home : NavigationItem("home", R.drawable.outline_home_24, "Home")
    object Search : NavigationItem("search", R.drawable.outline_search_24, "Search")
    object Profile : NavigationItem("profile", R.drawable.outline_person_outline_24, "Profile")
}

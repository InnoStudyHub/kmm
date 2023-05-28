package com.seytkalievm.studyhub.android.presentation.session.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.seytkalievm.studyhub.android.presentation.util.Screen

@Composable
fun ProfilePage(
    navController: NavController,
    viewModel: ProfilePageViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if(state.isLoggedInState) {
            Button(
                onClick = {
                    viewModel.logout()
                },
                modifier = Modifier
                    .width(320.dp)
                    .height(44.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Cyan),
            ) {
                Text(text = "Log out")
            }
        } else {
            LaunchedEffect(Unit) {
                //TODO(Navigation is not found. App crashes)
                navController.navigate(Screen.AuthScreen.route) {
                    popUpTo(Screen.HomeScreen.route) {inclusive = true}
                }
            }

        }
    }
}
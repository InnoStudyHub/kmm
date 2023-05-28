package com.seytkalievm.studyhub.android.presentation.auth.login

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.seytkalievm.studyhub.android.presentation.auth.EmailTextField
import com.seytkalievm.studyhub.android.presentation.auth.PasswordTextField
import com.seytkalievm.studyhub.android.presentation.util.Screen

@Composable
fun LoginScreen(
    navController: NavController,
    loginViewModel: LoginViewModel = hiltViewModel()
) {
    val state by loginViewModel.state.collectAsState()

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            val context = LocalContext.current
            if (state.isLoggedInState) {
                LaunchedEffect(Unit){
                    navController.navigate(Screen.HomeScreen.route) {
                        //TODO(exit app when backpressed)
                        popUpTo(Screen.LoadingScreen.route) {inclusive = true}
                    }
                }
            } else {
                EmailTextField(value = loginViewModel.login)
                PasswordTextField(value = loginViewModel.password)
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    onClick = {
                        if (loginViewModel.login.value.isNotEmpty()
                            && loginViewModel.password.value.isNotEmpty()
                        ) {
                            loginViewModel.login()
                        } else {
                            Toast.makeText(
                                context,
                                "Fields should not be empty",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                    }
                ) {
                    Text("Login")
                }
                Row {
                    Text("Don't have an account?")
                    Text(
                        text = "Register",
                        modifier = Modifier
                            .clickable {
                                navController.navigate("")
                            }
                    )
                }
            }
        }

    }
}
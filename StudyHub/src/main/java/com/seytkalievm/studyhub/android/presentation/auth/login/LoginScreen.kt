package com.seytkalievm.studyhub.android.presentation.auth.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
            if (state.isLoggedInState) {
                navController.navigate(Screen.HomeScreen.route)
            } else {
                EmailTextField(value = loginViewModel.login)
                PasswordTextField(value = loginViewModel.password)
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    onClick =  { loginViewModel.login() }
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
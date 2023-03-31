package com.seytkalievm.studyhub.android.presentation.auth.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.seytkalievm.studyhub.android.presentation.auth.EmailTextField
import com.seytkalievm.studyhub.android.presentation.auth.PasswordTextField

@Composable
fun LoginScreen(
    navController: NavController,
    loginViewModel: LoginViewModel = viewModel()
) {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
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
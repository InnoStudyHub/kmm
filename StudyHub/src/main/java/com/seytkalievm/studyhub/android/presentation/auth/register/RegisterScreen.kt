package com.seytkalievm.studyhub.android.presentation.auth.register

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.seytkalievm.studyhub.android.presentation.auth.EmailTextField
import com.seytkalievm.studyhub.android.presentation.auth.PasswordTextField

@Composable
fun RegisterScreen(
    navController: NavController,
    registerViewModel: RegisterViewModel = viewModel()
) {
    Scaffold {paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            EmailTextField(value = registerViewModel.email)
            PasswordTextField(value = registerViewModel.password)
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                singleLine = true,
                label = { Text("Full name") },
                value = registerViewModel.name.value,
                onValueChange = { name -> registerViewModel.name.value = name }
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                onClick = { registerViewModel.register() }
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
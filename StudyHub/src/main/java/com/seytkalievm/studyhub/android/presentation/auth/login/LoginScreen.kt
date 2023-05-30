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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.seytkalievm.studyhub.android.presentation.auth.EmailTextField
import com.seytkalievm.studyhub.android.presentation.auth.PasswordTextField

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = hiltViewModel()
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
            val context = LocalContext.current
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
                        modifier = Modifier.clickable {}
                    )
                }

        }

    }
}
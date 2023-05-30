package com.seytkalievm.studyhub.android.presentation.auth.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seytkalievm.studyhub.domain.api.AuthApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val api: AuthApi) : ViewModel() {

    val login = mutableStateOf("")
    val password = mutableStateOf("")

    fun login() {
        viewModelScope.launch(Dispatchers.IO) {
            api.login(login.value, password.value)
        }
    }
}
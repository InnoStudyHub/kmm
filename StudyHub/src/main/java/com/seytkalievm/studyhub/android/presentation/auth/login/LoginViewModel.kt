package com.seytkalievm.studyhub.android.presentation.auth.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seytkalievm.studyhub.domain.api.AuthApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val api: AuthApi
) : ViewModel() {

    val login = mutableStateOf("")
    val password = mutableStateOf("")

    private val isLoggedIn: Flow<Boolean> = savedStateHandle.getStateFlow("isLoggedIn", false)

    val state = isLoggedIn.map { isLoggedIn ->
        LoginPageState(isLoggedInState = isLoggedIn)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), LoginPageState())

    fun login() {
        //TODO: Валидация данных, навигация в session при успешном логине
        viewModelScope.launch(Dispatchers.IO) {
            api.login(login.value, password.value)
            savedStateHandle["isLoggedIn"] = api.isLoggedIn()
        }
    }

}
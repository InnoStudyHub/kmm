package com.seytkalievm.studyhub.android.presentation.auth.register

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class RegisterViewModel: ViewModel() {
    val email = mutableStateOf("")
    val name = mutableStateOf("")
    val password = mutableStateOf("")

    fun register(){
        /* TODO */
    }
}
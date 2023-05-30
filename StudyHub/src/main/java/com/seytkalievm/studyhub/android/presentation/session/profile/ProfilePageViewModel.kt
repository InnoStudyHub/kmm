package com.seytkalievm.studyhub.android.presentation.session.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seytkalievm.studyhub.domain.api.AuthApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfilePageViewModel @Inject constructor(private val authApi: AuthApi) : ViewModel() {

    fun logout() {
        viewModelScope.launch {
            authApi.logout()
        }
    }
}
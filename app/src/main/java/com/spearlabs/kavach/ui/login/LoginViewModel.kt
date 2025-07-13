package com.spearlabs.kavach.ui.login

import androidx.lifecycle.ViewModel
import com.spearlabs.kavach.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.text.Typography.dagger

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    fun loginWithGoogle(token: String, onComplete: (Boolean) -> Unit) {
        authRepository.signInWithGoogle(token, onComplete)
    }

    fun isUserLoggedIn() = authRepository.getCurrentUser() != null
}


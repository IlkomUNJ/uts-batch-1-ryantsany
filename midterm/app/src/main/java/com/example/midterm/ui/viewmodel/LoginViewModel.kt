package com.example.midterm.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class UserInformation(
    var isLoggedIn: Boolean = false,
    var username: String = "",
    var password: String = "",
)

class LoginViewModel: ViewModel() {
    private val _loginState = MutableStateFlow(UserInformation())
    val loginState: StateFlow<UserInformation> = _loginState.asStateFlow()

    private val dummy_username = "user1"
    private val dummy_password = "12345"

    fun login(username: String, password: String) {
        if (username != dummy_username || password != dummy_password) {
            return
        }

        _loginState.update {
            it.copy(
                isLoggedIn = true
            )
        }
    }
}
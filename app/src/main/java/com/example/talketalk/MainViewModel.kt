package com.example.talketalk

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val auth = FirebaseAuth.getInstance()

    // Splash screen waits for this
    private val _isReady = MutableStateFlow(false)
    val isReady = _isReady.asStateFlow()

    // True if user is already logged in
    val isLoggedIn: Boolean
        get() = auth.currentUser != null

    init {
        viewModelScope.launch {
            delay(1000L)
            _isReady.value = true
        }
    }
}
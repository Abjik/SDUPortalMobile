package com.example.sdu_portal_mobile.DB

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sdu_portal_mobile.repository.UserRepository
import com.example.sdu_portal_mobile.viewModels.LoginViewModel

class UserViewModelFactory(private val repository: UserRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LoginViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
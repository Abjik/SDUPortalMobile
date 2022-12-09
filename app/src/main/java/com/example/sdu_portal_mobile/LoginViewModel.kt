package com.example.sdu_portal_mobile


import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sdu_portal_mobile.DB.AccauntDatabase
import com.example.sdu_portal_mobile.repository.UserRepository
import com.example.sdu_portal_mobile.rvmvvm.Event
import com.example.sdu_portal_mobile.rvmvvm.Task
import kotlinx.coroutines.launch

//private val repository: UserRepository
class LoginViewModel(private val repository: UserRepository) : ViewModel() {
    val user = repository.getUse()

    private fun getUse() = viewModelScope.launch {
//        val idname = AccauntDatabase.getInstance().getAccDao().loadAllUsers()
//        val size = AccauntDatabase.getInstance().getAccDao().loadAllUsersSize()
    }
}
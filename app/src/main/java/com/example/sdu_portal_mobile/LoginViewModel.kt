package com.example.sdu_portal_mobile

import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.*
import com.example.sdu_portal_mobile.DB.AccauntDatabase
import com.example.sdu_portal_mobile.databinding.FragmentLoginBinding
import com.example.sdu_portal_mobile.repository.UserRepository
import kotlinx.coroutines.launch

        //private val repository: UserRepository
class LoginViewModel(private val repository: UserRepository): ViewModel() {
    private val _user = MutableLiveData("TEST")
    val user = _user
//    val allUser: LiveData<List<Int>> = repository.allUsers
    fun onLoginClicked() {
        viewModelScope.launch {
//            val idname = repository.allUsers.value
            val testi: Boolean = false
        }
    }
}

//
//class UserViewModelFactory(private val repository: UserRepository): ViewModelProvider.Factory{
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST")
//            return LoginViewModel(repository) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}
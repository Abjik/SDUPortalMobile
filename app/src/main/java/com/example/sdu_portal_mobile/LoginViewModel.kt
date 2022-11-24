package com.example.sdu_portal_mobile


import androidx.lifecycle.*
import com.example.sdu_portal_mobile.repository.UserRepository
import kotlinx.coroutines.launch

        //private val repository: UserRepository
class LoginViewModel(private val repository: UserRepository): ViewModel() {
    private val _user = MutableLiveData("TEST")
    val user = _user
//    val allUser: LiveData<Int> = repository.allUsers
    val UsersSize: Int = repository.sizes

    fun onLoginClicked() {
        viewModelScope.launch {
//            val idname = repository.allUsers
            val size = repository.sizes
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
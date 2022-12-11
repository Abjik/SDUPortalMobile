package com.example.sdu_portal_mobile


import androidx.lifecycle.*
import com.example.sdu_portal_mobile.repository.UserRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

//private val repository: UserRepository
class LoginViewModel(private val repository: UserRepository) : ViewModel() {
    private val users = MutableLiveData("TEST")
    val u = users
//    val user = repository.getUse()

    fun getUseres(idname: List<Int>) = viewModelScope.launch{
        val idname = listOf(repository.getUse().size)
    }


}
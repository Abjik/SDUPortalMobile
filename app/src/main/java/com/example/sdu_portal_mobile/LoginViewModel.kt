package com.example.sdu_portal_mobile.viewModels


import android.content.Context
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.*
import androidx.navigation.findNavController
import com.example.sdu_portal_mobile.DB.AccauntDatabase
import com.example.sdu_portal_mobile.R
import com.example.sdu_portal_mobile.fragments.LoginFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

//private val repository: UserRepository
//private val logi: LoginFragment
class LoginViewModel() : ViewModel() {
    //${logi.getText(login)}
    private var _prikol = MutableLiveData<Boolean>(false)
    val prikol: LiveData<Boolean>
        get() {
            return _test
        }

    private val _user = MutableLiveData("User id is: ")
    val user = _user

    private var _test = MutableLiveData<Boolean>(false)
    val test: LiveData<Boolean>
        get() {
            return _test
        }

    fun login(context: Context, login:String, password: String){
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val logi = login
                val pass = password
                val idname =
                    AccauntDatabase.getInstance(context).getAccDao().loadAllUsers()
                val size = AccauntDatabase.getInstance(context).getAccDao().loadAllUsersSize()
                for (i in IntRange(0, size - 1)) {
                    if (logi == idname[i].toString() &&  pass == idname[i].toString()) {
                        LoginFragment.setSduId(logi)
                        _test.postValue(true)
                        break
                    }
                }
            }

        }
    }
}

//    val allUser: LiveData<Int> = repository.allUsers
//    val UsersSize: Int = repository.sizes

//    fun onLoginClicked() {
//        viewModelScope.launch {
//            val idname = repository.allUsers
//            val size = repository.sizes
//            val testi: Boolean = false
//
//        }
//    }
//}

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
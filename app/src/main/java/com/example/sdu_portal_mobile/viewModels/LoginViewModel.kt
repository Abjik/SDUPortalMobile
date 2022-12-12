package com.example.sdu_portal_mobile.viewModels


import android.content.Context
import androidx.lifecycle.*
import com.example.sdu_portal_mobile.DB.AccauntDatabase
import com.example.sdu_portal_mobile.fragments.LoginFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

//private val repository: UserRepository
        //private val logi: LoginFragment
class LoginViewModel(): ViewModel() {
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
//                        LoginFragment.setSduId(logi)
                        _test.postValue(true)
                        break
                    }
                }
            }

        }
    }
}

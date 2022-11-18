package com.example.sdu_portal_mobile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class LoginViewModel: ViewModel() {
    private val _user = MutableLiveData("gay")
    val user = _user
}
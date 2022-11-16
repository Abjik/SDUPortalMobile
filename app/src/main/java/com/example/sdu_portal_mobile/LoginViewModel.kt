package com.example.sdu_portal_mobile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sdu_portal_mobile.DB.AccDao
import com.example.sdu_portal_mobile.DB.AccauntDatabase
import com.example.sdu_portal_mobile.DB.AccauntTuple
import okhttp3.internal.userAgent


class LoginViewModel: ViewModel() {
    private val _user = MutableLiveData("gay")
    val user = _user
}
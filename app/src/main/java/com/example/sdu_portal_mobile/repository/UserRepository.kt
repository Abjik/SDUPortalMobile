package com.example.sdu_portal_mobile.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sdu_portal_mobile.DB.AccDao
import com.example.sdu_portal_mobile.rvmvvm.Task
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow

class UserRepository(private val accDao: AccDao){
//    val allUsers: LiveData<Int> = accDao.loadAllUsers()
    val sizes : Int = accDao.loadAllUsersSize()
    suspend fun sizes(task: Task):Long{
        return dao.insertTask(task)
    }
}
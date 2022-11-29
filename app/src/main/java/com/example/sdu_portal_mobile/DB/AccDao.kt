package com.example.sdu_portal_mobile.DB

import android.os.Build.ID
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AccDao {

    @Query("select ID from students")
    fun loadAllUsers(): List<Int>

    @Query("select COUNT(ID) from students")
    fun loadAllUsersSize(): Int
}
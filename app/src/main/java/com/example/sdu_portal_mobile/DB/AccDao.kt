package com.example.sdu_portal_mobile.DB

import android.os.Build.ID
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AccDao {

    @Query("select ID from students")
    suspend fun loadAllUsers(): Array<Int>

}
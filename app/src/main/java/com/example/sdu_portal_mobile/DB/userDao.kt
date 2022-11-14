package com.example.sdu_portal_mobile.DB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface userDao {
    @Insert
    fun insert(id: userTable)

    @Update
    fun update(id: userTable)

    @Query("SELECT * from StudInf WHERE ID = :key")
    fun get(key: Long): userTable?

    @Query("DELETE FROM StudInf")
    fun clear()

    @Query("SELECT * FROM StudInf ORDER BY ID DESC LIMIT 1")
    fun getNum(): userTable?

    @Query("SELECT * FROM StudInf ORDER BY ID DESC")
    fun getAllNights(): LiveData<List<userTable>>
}
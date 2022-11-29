package com.example.sdu_portal_mobile.rvmvvm

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDAO {
    @Insert
    suspend fun insertTask(task: Task) : Long

    @Update
    suspend fun updateTask(task: Task) : Int

    @Delete
    suspend fun deleteTask(task: Task) : Int

    @Query("DELETE FROM task_data_table")
    suspend fun deleteAll() : Int

    @Query("SELECT * FROM task_data_table")
    fun getAllTask():Flow<List<Task>>
}
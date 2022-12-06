package com.example.sdu_portal_mobile.DB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ScheduleDatabaseDao {
    @Insert
    fun insert(schedule: ScheduleTable)

    @Update
    fun update(schedule: ScheduleTable)

    @Query("SELECT * from student_schedule_table WHERE studentID = :id AND week_day = :weekDay")
    fun get(id: Long, weekDay: String): ScheduleTable?

    @Query("SELECT * FROM student_schedule_table ORDER BY studentID DESC LIMIT 1")
    fun getForTest(): ScheduleTable?

    @Query("DELETE FROM student_schedule_table")
    fun clear()

    @Query("SELECT * FROM student_schedule_table ORDER BY studentId DESC")
    fun getAllSchedules(): LiveData<List<ScheduleTable>>

}
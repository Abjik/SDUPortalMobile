package com.example.sdu_portal_mobile.DB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "student_schedule_table")
data class ScheduleTable(

    @PrimaryKey
    var studentID: Long = 0L,

    @ColumnInfo(name = "week_day")
    val weekDay: String = "",

    @ColumnInfo(name = "time_interval")
    val timeInterval: String = "",

    @ColumnInfo(name = "course_code")
    var courseCode: String = "",

    @ColumnInfo(name = "course_name")
    var courseName: String = "",

    @ColumnInfo(name = "cabinet")
    var cabinet: String = "",
)
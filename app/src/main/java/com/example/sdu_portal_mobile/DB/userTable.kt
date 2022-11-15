package com.example.sdu_portal_mobile.DB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students")
data class StudentsTable(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val users: String,
    val pass: String
){
    fun toStudentsTable(): Students = Students(
        id = id,
        users = users,
        pass = pass
    )
}
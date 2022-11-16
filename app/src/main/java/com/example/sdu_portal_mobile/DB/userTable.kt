package com.example.sdu_portal_mobile.DB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students")
data class StudentsTable(
    @PrimaryKey(autoGenerate = true) val key: Long,
    val ID: Int,
    val Name: String,
    val Surname: String,
    val Speciality: String
){
    fun toStudentsTable(): Students = Students(
        key = key,
        ID = ID,
        Name = Name,
        Speciality = Speciality
    )
}
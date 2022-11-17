package com.example.sdu_portal_mobile.DB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students")
data class StudentsTable(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    val id: Int,

    @ColumnInfo(name = "Name")
    val name: String,

    @ColumnInfo(name = "Surname")
    val surname: String,

    @ColumnInfo(name = "Speciality")
    val speciality: String,

    @ColumnInfo(name = "Course")
    val course: Int,

    @ColumnInfo(name = "Nsection")
    val nsection: String,

    @ColumnInfo(name = "N_Instructor")
    val n_instructor: String,

    @ColumnInfo(name = "Psection")
    val psection: String,

    @ColumnInfo(name = "P_Instructor")
    val p_instructor: String,

){
    fun toStudentsTable(): Students = Students(
        id = id,
        name = name,
        surname = surname,
        speciality = speciality,
        course = course,
        nsection = nsection,
        n_instructor = n_instructor,
        psection = psection,
        p_instructor = p_instructor
    )
}
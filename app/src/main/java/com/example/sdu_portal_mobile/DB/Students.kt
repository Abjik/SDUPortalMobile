package com.example.sdu_portal_mobile.DB

import androidx.room.ColumnInfo

data class Students (
    val id: Int,
    val name: String,
    val surname: String,
    val speciality: String,
    val course: Int,
    val nsection: String,
    val n_instructor: String,
    val psection: String,
    val p_instructor: String,

    )
package com.example.sdu_portal_mobile.DB


data class Lesson (
    val sduId: String ?= null,
    val weekday: String ?= null,
    val timeInterval: String ?= null,
    val courseCode: String ?= null,
    val courseName: String ?= null,
    val cabinet: String ?= null
    )


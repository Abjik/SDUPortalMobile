package com.example.sdu_portal_mobile.DB


data class Lesson (
    val id: String,
    val sduId: String,
    val weekday: String,
    val timeInterval: String,
    val courseCode: String,
    val courseName: String,
    val cabinet: String
    )
//data class MarsProperty(
//    val id: String,
//    @Json(name = "img_src") val imgSrcUrl: String,
//    val type: String,
//    val price: Double
//)
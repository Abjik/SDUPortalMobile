package com.example.sdu_portal_mobile.network

import com.example.sdu_portal_mobile.DB.Lesson
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://sdu-mobile-cd4a4-default-rtdb.europe-west1.firebasedatabase.app/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ScheduleApiService {
    @GET("realestate")
    fun getProperties():
            List<Lesson>
}

object ScheduleApi {
    val retrofitService : ScheduleApiService by lazy {
        retrofit.create(ScheduleApiService::class.java) }
}
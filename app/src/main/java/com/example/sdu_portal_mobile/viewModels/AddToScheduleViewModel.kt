package com.example.sdu_portal_mobile.viewModels

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sdu_portal_mobile.DB.Lesson
import com.example.sdu_portal_mobile.network.ScheduleApi
import com.example.sdu_portal_mobile.network.ScheduleApiService
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class AddToScheduleViewModel : ViewModel() {

    private var _data: MutableLiveData<ArrayList<Lesson>>? = MutableLiveData()
    private lateinit var database: DatabaseReference
    public val LESSONKEY = "Lessons"
    val data: LiveData<ArrayList<Lesson>>
        get() = getUser()

    fun getUser(): MutableLiveData<ArrayList<Lesson>> {
        if (_data == null) {
            _data = MutableLiveData<ArrayList<Lesson>>();
        }
        return _data as MutableLiveData<ArrayList<Lesson>>
    }

//        private fun getLessonToSchedule() {
//        viewModelScope.launch {
//            try {
//                val listResult = ScheduleApi.retrofitService.getProperties()
//
//                _data.value.
//                    "Success: ${listResult.size} Mars properties retrieved"
//            } catch (e: Exception) {
//                _response.value = "Failure: ${e.message}"
//            }
//        }
//    }
    init {
        database =
            FirebaseDatabase.getInstance("https://sdu-mobile-cd4a4-default-rtdb.europe-west1.firebasedatabase.app/").reference
    }

    fun addLessonToSchedule(
        sduId: String, weekDay: String, timeInterval: String, courseCode: String,
        courseName: String, cabinet: String
    ) {

        val lesson = Lesson(sduId, weekDay, timeInterval, courseCode, courseName, cabinet)
        database.child(LESSONKEY).child(sduId).push().setValue(lesson)
    }

}
package com.example.sdu_portal_mobile.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sdu_portal_mobile.DB.Lesson
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddToScheduleViewModel : ViewModel() {

    private var _data: MutableLiveData<ArrayList<Lesson>>? = MutableLiveData()
    private lateinit var database: DatabaseReference
    val LESSONKEY = "Lessons"
    val data: LiveData<ArrayList<Lesson>>
        get() = getUser()

    fun getUser(): MutableLiveData<ArrayList<Lesson>> {
        if (_data == null) {
            _data = MutableLiveData<ArrayList<Lesson>>();
        }
        return _data as MutableLiveData<ArrayList<Lesson>>
    }

    init {
        database =
            FirebaseDatabase.getInstance("https://sdu-mobile-cd4a4-default-rtdb.europe-west1.firebasedatabase.app/").reference
    }

    fun addLessonToSchedule(
        sduId: String, weekDay: String, timeInterval: String, courseCode: String,
        courseName: String, cabinet: String
    ) {

        val lesson = Lesson(sduId, weekDay, timeInterval, courseCode, courseName, cabinet)
        database.child(LESSONKEY).child(sduId).child(weekDay).push().setValue(lesson)
    }

}
package com.example.sdu_portal_mobile.viewModels

import android.app.Application
import android.provider.SyncStateContract.Helpers.update
import android.text.method.TextKeyListener.clear
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sdu_portal_mobile.DB.ScheduleDatabaseDao
import com.example.sdu_portal_mobile.DB.ScheduleTable
import kotlinx.coroutines.launch
import java.util.*

//(
//    private val database: ScheduleDatabaseDao,
//    application: Application
//)
class ScheduleViewModel : ViewModel() {
//    val schedules = database.getAllSchedules()

    private var calendar: Calendar = Calendar.getInstance()
    private var day =  if ((calendar.get(Calendar.DAY_OF_WEEK)-2) < 0) {7 - (calendar.get(Calendar.DAY_OF_WEEK)-2) } else (calendar.get(Calendar.DAY_OF_WEEK)-2)
    private var weekdays =
        arrayOf("Monday", "Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday")



    private var _currentWeekDay = MutableLiveData<String>(weekdays[day])
    val currentWeekDay: LiveData<String>
        get() = _currentWeekDay

    fun setPreviousWeekDay(){
        if(day == 0) {
            day = 6
        }
        else{
            day -= 1
        }
        _currentWeekDay.value = weekdays[day]
    }
    fun setNextWeekDay(){
        if(day == 6) {
            day = 0
        }
        else{
            day += 1
        }
        _currentWeekDay.value = weekdays[day]
    }

//    fun onClear() {
//        viewModelScope.launch {
//            clear()
//        }
//    }

//    private suspend fun update(schedule: ScheduleTable) {
//        database.update(schedule)
//    }
//
//    suspend fun clear() {
//        database.clear()
//    }

}
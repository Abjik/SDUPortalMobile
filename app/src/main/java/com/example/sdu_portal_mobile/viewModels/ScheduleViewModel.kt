package com.example.sdu_portal_mobile.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

//(
//    private val database: ScheduleDatabaseDao,
//    application: Application
//)
class ScheduleViewModel : ViewModel() {

    private var day =  getCurrentWeekDay()
    private var weekdays =
        arrayOf("Monday", "Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday")

    private var _currentWeekDay = MutableLiveData<String>(weekdays[day])
    val currentWeekDay: LiveData<String>
        get() = _currentWeekDay

    private fun getCurrentWeekDay(): Int {
        val calendar = Calendar.getInstance()
        val day = calendar[Calendar.DAY_OF_WEEK]

        when (day) {
            Calendar.SUNDAY -> {return 6}
            Calendar.MONDAY -> {return 0}
            Calendar.TUESDAY -> {return 1}
            Calendar.WEDNESDAY -> {return 2}
            Calendar.THURSDAY -> {return 3}
            Calendar.FRIDAY -> {return 4}
            Calendar.SATURDAY -> {return 5}
        }
        return 0
    }

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
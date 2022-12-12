package com.example.sdu_portal_mobile.rvmvvm

import androidx.lifecycle.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.*

class TaskViewModel(private val repository: TaskRepository):ViewModel() {
    val inputTitle = MutableLiveData<String>()
    val inputSubTitle = MutableLiveData<String>()
    val addTodoButton = MutableLiveData<String>()

    private val statusMessage = MutableLiveData<Event<String>>()
    val message: LiveData<Event<String>>
        get() = statusMessage

    init{
        addTodoButton.value = "Add Todo"
    }

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

    fun addTask(){
        if (inputTitle.value == null){
            statusMessage.value = Event("Enter Todo Title")
        }
        else if(inputSubTitle.value == null){
            statusMessage.value = Event("Enter Deadline")
        }
        else {
            val title = inputTitle.value!!
            val subTitle = inputSubTitle.value!!
            insertTask(Task(0, title, subTitle))
            inputTitle.value = ""
            inputSubTitle.value = ""
        }
    }

    private fun insertTask(task: Task) = viewModelScope.launch{
        val newRowId = repository.insert(task)

        if (newRowId > -1) {
            statusMessage.value = Event("Task Added $newRowId")
        } else {
            statusMessage.value = Event("Error Occurred")
        }
    }

    fun getAllTask() = liveData{
        repository.tasks.collect(){
            emit(it)
        }
    }

}
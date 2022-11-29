package com.example.sdu_portal_mobile.rvmvvm

import androidx.lifecycle.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

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

    fun addTask(){
        if (inputTitle == null){
            statusMessage.value = Event("Enter Todo Title")
        }
        else if(inputSubTitle == null){
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
package com.example.sdu_portal_mobile.rvmvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TaskViewModel(private val repository: TaskRepository):ViewModel() {
    val inputTitle = MutableLiveData<String>()
    val inputSubTitle = MutableLiveData<String>()
    val addTodoButton = MutableLiveData<String>()

    init{
        addTodoButton.value = "Add Todo"
    }

    fun addTask(){
        val title = inputTitle.value!!
        val subTitle = inputSubTitle.value!!
        insertTask(Task(0, title, subTitle))
        inputTitle.value = ""
        inputSubTitle.value = ""
    }

    private fun insertTask(task: Task) = viewModelScope.launch{
        repository.insert(task)
    }
}
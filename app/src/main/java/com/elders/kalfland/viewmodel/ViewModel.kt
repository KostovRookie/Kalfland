package com.elders.kalfland.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.elders.kalfland.dataClass.ToDo
import com.elders.kalfland.repository.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel
@Inject
constructor(private val ShoppingRepository: ToDoRepository) : ViewModel() {

    fun insertToDo(toDo: ToDo) = viewModelScope.launch {
        ShoppingRepository.insertToDo(toDo)
    }

    fun deleteToDo(toDo: ToDo) = viewModelScope.launch {
        ShoppingRepository.deleteToDo(toDo)
    }

    val allToDos = ShoppingRepository.getAllToDo().asLiveData()

}
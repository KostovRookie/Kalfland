package com.elders.kalfland.repository

import com.elders.kalfland.database.DaoCommands
import com.elders.kalfland.dataClass.ToDo
import javax.inject.Inject


class ToDoRepository
@Inject
constructor(private val daoCommands: DaoCommands) {

    suspend fun insertToDo(toDo: ToDo) = daoCommands.insertToDo(toDo)
    suspend fun deleteToDo(toDo: ToDo) = daoCommands.deleteToDo(toDo)
    fun getAllToDo() = daoCommands.getAllToDos()

}
package com.elders.kalfland.database

import androidx.room.*
import com.elders.kalfland.dataClass.ToDo
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoCommands {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToDo(toDo: ToDo)

    @Delete
    suspend fun deleteToDo(toDo: ToDo)

    @Query("SELECT * FROM todo ORDER BY toDoTitle ASC ")
    fun getAllToDos(): Flow<List<ToDo>>


}
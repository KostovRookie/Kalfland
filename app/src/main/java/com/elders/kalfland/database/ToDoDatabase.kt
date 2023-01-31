package com.elders.kalfland.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.elders.kalfland.dataClass.ToDo

@Database(
    entities = [ToDo::class],
    version = 1, exportSchema = false
)
abstract class ToDoDatabase : RoomDatabase() {

    abstract fun toDoDao(): DaoCommands

}
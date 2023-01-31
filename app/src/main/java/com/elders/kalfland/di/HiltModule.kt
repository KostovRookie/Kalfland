package com.elders.kalfland.di


import android.content.Context
import androidx.room.Room
import com.elders.kalfland.database.ToDoDatabase
import com.elders.kalfland.utils.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Singleton
    @Provides
    fun provideToDoDataBase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context, ToDoDatabase::class.java,
        DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideToDoDao(
        db: ToDoDatabase
    ) = db.toDoDao()

}
package com.example.notesapp.di

import android.app.Application
import androidx.room.Room
import com.example.notesapp.data_layer.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {
    @Provides
    @Singleton
    fun provideDatabase(application: Application): NoteDatabase {
        return Room.databaseBuilder(
            context = application,
            NoteDatabase::class.java,
            "note_database.sql"
        ).build()
    }
}
package com.example.notesapp.data_layer

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Upsert
    suspend fun upsert(note: Note)
    @Delete
    suspend fun delete(note: Note)
    @Query("select * from note order by dateDated asc")
    fun getAllOrderedDataAdded(): Flow<List<Note>>
    @Query("select * from note order by title asc")
    fun getAllOrderedTitle(): Flow<List<Note>>
}
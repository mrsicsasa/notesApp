package com.example.notesapp.ui_layer

import com.example.notesapp.data_layer.Note

sealed interface NoteEvent {
    object SortNotes : NoteEvent
    data class DeleteNote (val note: Note) : NoteEvent
    data class SaveNote(val title: String, var description: String): NoteEvent
}
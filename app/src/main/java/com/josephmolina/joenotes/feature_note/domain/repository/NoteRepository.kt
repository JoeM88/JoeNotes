package com.josephmolina.joenotes.feature_note.domain.repository

import com.josephmolina.joenotes.domain.model.Note
import kotlinx.coroutines.flow.Flow

// Good for testing
// We can create fake versions of this repository
// Implementations of this will happen in the data layer
interface NoteRepository {

    fun getNotes(): Flow<List<Note>>

    suspend fun getNoteById(id: Int): Note?

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)

}
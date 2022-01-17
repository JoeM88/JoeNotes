package com.josephmolina.joenotes.feature_note.presentation.notes

import com.josephmolina.joenotes.domain.model.Note
import com.josephmolina.joenotes.feature_note.domain.util.NoteOrder

sealed class NotesEvents {
    data class Order(val noteOrder: NoteOrder) : NotesEvents()
    data class DeleteNote(val note: Note) : NotesEvents()
    object RestoreNote : NotesEvents()
    object ToggleOrderSection : NotesEvents()
}

package com.josephmolina.joenotes.feature_note.domain.use_case

import com.josephmolina.joenotes.domain.model.Note
import com.josephmolina.joenotes.feature_note.domain.repository.NoteRepository

class DeleteNoteUseCase(private val repository: NoteRepository) {
    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}
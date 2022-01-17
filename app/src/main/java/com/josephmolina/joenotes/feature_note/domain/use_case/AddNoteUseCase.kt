package com.josephmolina.joenotes.feature_note.domain.use_case

import com.josephmolina.joenotes.domain.model.InvalidNoteException
import com.josephmolina.joenotes.domain.model.Note
import com.josephmolina.joenotes.feature_note.domain.repository.NoteRepository

/*
Before we add the note we need to verify that it has a title
and other thing because of this we add checks here.
Those checks are business logic and do not belong in the presentation
nor the viewmodel. (they can be)
 */
class AddNoteUseCase (private val repository: NoteRepository) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("The title of the note can't be empty.")
        }

        if (note.content.isBlank()) {
            throw InvalidNoteException("The content of the note can't be empty.")
        }

        repository.insertNote(note)
    }
}
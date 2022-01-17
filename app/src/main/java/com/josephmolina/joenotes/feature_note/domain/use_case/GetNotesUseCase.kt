package com.josephmolina.joenotes.feature_note.domain.use_case

import com.josephmolina.joenotes.domain.model.Note
import com.josephmolina.joenotes.feature_note.domain.repository.NoteRepository
import com.josephmolina.joenotes.feature_note.domain.util.NoteOrder
import com.josephmolina.joenotes.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/*
The interface is passed here so we can replace it with our fake repository
in our tests

Usecases should only have one public method that executes the usecase
They can have private functions

 */
class GetNotesUseCase(private val repository: NoteRepository) {
    // This allows us to call our class like function
    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)
    ): Flow<List<Note>> {
        return repository.getNotes().map { notes ->
            when (noteOrder.orderType) {
                is OrderType.Ascending -> {
                    when (noteOrder) {
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                    }
                }
                is OrderType.Descending -> {
                    when (noteOrder) {
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedByDescending { it.timestamp }
                        is NoteOrder.Color -> notes.sortedByDescending { it.color }
                    }
                }
            }
        }
    }
}

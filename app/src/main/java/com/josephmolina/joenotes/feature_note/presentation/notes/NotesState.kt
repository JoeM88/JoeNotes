package com.josephmolina.joenotes.feature_note.presentation.notes

import com.josephmolina.joenotes.domain.model.Note
import com.josephmolina.joenotes.feature_note.domain.util.NoteOrder
import com.josephmolina.joenotes.feature_note.domain.util.OrderType

data class NotesState(
    private val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
) {
}
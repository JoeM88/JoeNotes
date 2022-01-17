package com.josephmolina.joenotes.feature_note.domain.use_case
/*
Normally we would inject every usecase into a viewmodel but as the app
grows we would have a huge constructor for the viewmodel.
A wrapper class that we can use to call the other usecases related to this feature
Inject single class that contains usecases into the viewmodel
Usecases will contain business logic
 */
data class NoteUseCases(
    val getNoteUseCase: GetNotesUseCase,
    val deleteNoteUseCase: DeleteNoteUseCase,
    val addNoteUseCase: AddNoteUseCase
)
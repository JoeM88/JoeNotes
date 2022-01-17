package com.josephmolina.joenotes.di

import android.app.Application
import androidx.room.Room
import com.josephmolina.joenotes.feature_note.data.data_source.NoteDatabase
import com.josephmolina.joenotes.feature_note.data.repository.NoteRepositoryImpl
import com.josephmolina.joenotes.feature_note.domain.repository.NoteRepository
import com.josephmolina.joenotes.feature_note.domain.use_case.AddNoteUseCase
import com.josephmolina.joenotes.feature_note.domain.use_case.DeleteNoteUseCase
import com.josephmolina.joenotes.feature_note.domain.use_case.GetNotesUseCase
import com.josephmolina.joenotes.feature_note.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app, NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    /*
    To test this we can create a testRepository and extend NoteRepository
     */
    @Provides
    @Singleton
    fun providesNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun providesNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(GetNotesUseCase(repository), DeleteNoteUseCase(repository), AddNoteUseCase(repository))
    }
}
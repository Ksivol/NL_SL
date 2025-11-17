package com.example.nl_sl.domain.usecase

import com.example.nl_sl.domain.model.NoteItemModel
import com.example.nl_sl.domain.repository.NoteRepository

class InsertNoteUseCase(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(noteItemModel: NoteItemModel){
        noteRepository.insertNote(noteItemModel)
    }
}
package com.example.nl_sl.domain.usecase

import com.example.nl_sl.domain.model.NoteItemModel
import com.example.nl_sl.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class GetAllNotesUseCase(private val noteRepository: NoteRepository) {
    operator fun invoke(): Flow<List<NoteItemModel>> {
        return noteRepository.getAllNotes()
    }
}
package com.example.nl_sl.domain.repository


import com.example.nl_sl.domain.model.NoteItemModel
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getAllNotes(): Flow<List<NoteItemModel>>

    suspend fun insertNote(note: NoteItemModel)
}
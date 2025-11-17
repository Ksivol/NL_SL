package com.example.nl_sl.data.repository

import com.example.nl_sl.data.dao.NoteDao
import com.example.nl_sl.data.entity.NoteItemEntity
import com.example.nl_sl.data.utils.toEntity
import com.example.nl_sl.data.utils.toModel
import com.example.nl_sl.domain.model.NoteItemModel
import com.example.nl_sl.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NoteRepositoryImpl(private val noteDao: NoteDao): NoteRepository {
    override fun getAllNotes(): Flow<List<NoteItemModel>> {
        return noteDao.getAllNotes().map { it.map(NoteItemEntity::toModel) }
    }

    override suspend fun insertNote(note: NoteItemModel) {
        noteDao.insertNote(note.toEntity())
    }

}
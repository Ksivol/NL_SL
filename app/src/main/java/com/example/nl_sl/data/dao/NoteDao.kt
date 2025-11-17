package com.example.nl_sl.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.nl_sl.data.entity.NoteItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT * FROM note_list")
    fun getAllNotes(): Flow<List<NoteItemEntity>>

    @Insert
    suspend fun insertNote(note: NoteItemEntity)
}
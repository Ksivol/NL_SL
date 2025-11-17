package com.example.nl_sl.domain.model

data class NoteItemModel(
    val id: Int?,
    val title: String,
    val content: String,
    val time: String,
    val category: String
)
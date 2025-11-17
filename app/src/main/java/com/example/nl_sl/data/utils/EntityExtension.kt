package com.example.nl_sl.data.utils

import com.example.nl_sl.data.entity.NoteItemEntity
import com.example.nl_sl.domain.model.NoteItemModel

fun NoteItemModel.toEntity(): NoteItemEntity {
    return NoteItemEntity(
        id = id,
        title = title,
        content = content,
        time = time,
        category = category
    )
}

fun NoteItemEntity.toModel(): NoteItemModel {
    return NoteItemModel(
        id = id,
        title = title,
        content = content,
        time = time,
        category = category
    )
}
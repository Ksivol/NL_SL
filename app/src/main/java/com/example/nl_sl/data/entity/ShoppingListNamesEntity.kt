package com.example.nl_sl.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "shopping_list_names")
data class ShoppingListNamesEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "time")
    val time: String,

    @ColumnInfo(name = "allItemCount")
    val allItemCount: Int,

    @ColumnInfo(name = "checkedItemCounter")
    val checkedItemCounter: Int,

    @ColumnInfo(name = "itemsIds")
    val itemsIds: Int,

    ) : Serializable

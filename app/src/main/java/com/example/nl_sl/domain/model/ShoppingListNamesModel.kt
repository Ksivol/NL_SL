package com.example.nl_sl.domain.model

import java.io.Serializable

data class ShoppingListNamesModel(
    val id: Int?,
    val name: String,
    val time: String,
    val allItemCount: Int,
    val checkedItemCounter: Int,
    val itemsIds: Int,
) : Serializable
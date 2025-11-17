package com.example.nl_sl.domain.model

data class ShoppingListItemModel(
    val id: Int,
    val name: String,
    val itemInfo: String,
    val itemChecked: Int = 0,
    val listId: Int,
    val itemType: String = "item"
)

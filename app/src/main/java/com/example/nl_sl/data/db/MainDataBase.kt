package com.example.nl_sl.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.nl_sl.data.dao.NoteDao
import com.example.nl_sl.data.entity.LibraryItemEntity
import com.example.nl_sl.data.entity.NoteItemEntity
import com.example.nl_sl.data.entity.ShoppingListItemEntity
import com.example.nl_sl.data.entity.ShoppingListNamesEntity

@Database (entities = [LibraryItemEntity::class, NoteItemEntity::class, ShoppingListItemEntity::class, ShoppingListNamesEntity::class], version = 1)
abstract class MainDataBase : RoomDatabase() {
    abstract fun getDao(): NoteDao

    companion object {
        @Volatile
        private var INSTANCE: MainDataBase? = null
        fun getDataBase(context: Context): MainDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MainDataBase::class.java,
                    "shopping_list.db"
                ).build()
                instance
            }
        }
    }
}
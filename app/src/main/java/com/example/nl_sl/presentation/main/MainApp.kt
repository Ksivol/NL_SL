package com.example.nl_sl.presentation.main

import android.app.Application
import com.example.nl_sl.data.db.MainDataBase

class MainApp : Application() {
    val database by lazy {MainDataBase.getDataBase(this)}
}
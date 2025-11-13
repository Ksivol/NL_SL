package com.example.nl_sl.activities

import android.app.Application
import com.example.nl_sl.db.MainDataBase

class MainApp : Application() {
    val database by lazy {MainDataBase.getDataBase(this)}
}
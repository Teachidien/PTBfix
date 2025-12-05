package com.example.ptbfix

import android.app.Application
import com.example.ptbfix.data.local.AppDatabase
import com.example.ptbfix.data.local.DatabaseRepository
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PTBApplication : Application() {
    
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { DatabaseRepository(database.userDao(), database.noteDao(), database.atletDao()) }
}

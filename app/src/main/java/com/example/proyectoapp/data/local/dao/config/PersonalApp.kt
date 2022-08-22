package com.example.proyectoapp.data.local.dao.config

import android.app.Application
import androidx.room.Room

class PersonalApp:Application() {
    companion object{
        lateinit var db:PersonalDb
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            this,
            PersonalDb::class.java,
            "personal"
        ).build()
    }
}

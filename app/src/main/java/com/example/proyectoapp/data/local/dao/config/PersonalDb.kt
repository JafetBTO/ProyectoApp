package com.example.proyectoapp.data.local.dao.config

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.proyectoapp.data.local.dao.PersonalDao
import com.example.proyectoapp.model.Personal

@Database(
    entities = [Personal::class],
    version = 1
)

abstract class PersonalDb:RoomDatabase() {
    abstract fun personalDao():PersonalDao
}
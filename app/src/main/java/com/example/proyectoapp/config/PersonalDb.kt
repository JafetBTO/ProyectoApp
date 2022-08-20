package com.example.proyectoapp.config

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.proyectoapp.dao.PersonalDao
import com.example.proyectoapp.model.Personal

@Database(
    entities = [Personal::class],
    version = 1
)

abstract class PersonalDb:RoomDatabase() {
    abstract fun personalDao():PersonalDao
}
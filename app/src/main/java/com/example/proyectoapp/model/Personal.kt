package com.example.proyectoapp.model


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Personal (
    @PrimaryKey(autoGenerate = true)
    var idEmpleado:Long,
    var nombre:String,
    var apellido:String,
    var email:String,
    var telefono:String,
    var edad:Int
)
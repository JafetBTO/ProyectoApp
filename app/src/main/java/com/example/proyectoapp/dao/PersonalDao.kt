package com.example.proyectoapp.dao

import androidx.room.*

import com.example.proyectoapp.model.Personal

@Dao
interface PersonalDao {

    @Query("SELECT * FROM Personal")
    suspend fun getAll():List<Personal>


    @Query("SELECT * FROM Personal WHERE idEmpleado = :id")
    suspend fun getById(id:Long):Personal

    @Query("SELECT * FROM Personal WHERE nombre LIKE '%' || :name || '%' OR apellido  LIKE '%' || :name || '%'")
    suspend fun getbyName(name:String):List<Personal>

    @Insert
    suspend fun insert(personas:List<Personal>):List<Long>

    @Update
    suspend fun update(personal: Personal):Int

    @Delete
    suspend fun delete(personal: Personal):Int
}
package com.example.proyectoapp.repository

import com.example.proyectoapp.services.RetrofitClient
import com.example.proyectoapp.services.WebService

class PokemonRepository {
    private var apiService: WebService? = null

    init {
        apiService = RetrofitClient.getClient?.create(WebService::class.java)
    }

    suspend fun getPokemon() = apiService?.getPokemons()
}
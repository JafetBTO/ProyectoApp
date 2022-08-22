package com.example.proyectoapp.data.network.repository

import com.example.proyectoapp.data.network.services.RetrofitClient
import com.example.proyectoapp.data.network.services.WebService

class PokemonRepository {
    private var apiService: WebService? = null

    init {
        apiService = RetrofitClient.getClient?.create(WebService::class.java)
    }

    suspend fun getPokemon() = apiService?.getPokemons()
}
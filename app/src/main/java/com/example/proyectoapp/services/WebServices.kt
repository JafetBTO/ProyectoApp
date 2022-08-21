package com.example.proyectoapp.services


import com.example.proyectoapp.model.PokemonResponse
import retrofit2.Response
import retrofit2.http.GET

interface WebService {
    @GET("pokedex.json")

    suspend fun getPokemons(): Response<PokemonResponse>
}
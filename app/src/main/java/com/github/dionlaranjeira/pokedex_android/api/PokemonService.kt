package com.github.dionlaranjeira.pokedex_android.api

import com.github.dionlaranjeira.pokedex_android.api.model.PokemonApiResult
import com.github.dionlaranjeira.pokedex_android.api.model.PokemonsApiResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface PokemonService {

    @GET("pokemon")
    fun listPokemons(@Query("limit") limit: Int): Call<PokemonsApiResult>

    @GET("pokemon/{number}")
    fun getPokemon(number: Int): Call<PokemonApiResult>

}
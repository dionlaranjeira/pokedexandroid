package com.github.dionlaranjeira.pokedex_android.api

import android.util.Log
//import com.github.dionlaranjeira.pokedex_android.api.model.PokemonResult
import com.github.dionlaranjeira.pokedex_android.api.model.PokemonsApiResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonRepository {

    //https://pokeapi.co/api/v2/pokemon/?limit=151
    private val service: PokemonService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(PokemonService::class.java)
    }

    fun listPokemons(limit: Int = 151): PokemonsApiResult? {
       val call = service.listPokemons(limit)
            return call.execute().body()
//        call.enqueue(object : Callback<PokemonsApiResult>{
//            override fun onResponse(
//                call: Call<PokemonsApiResult>,
//                response: Response<PokemonsApiResult>
//            ) {
//
//                if(response.isSuccessful){
//                    val body = response.body()
//
//                    body?.results?.let { list: List<PokemonResult> ->  }
//                }
//
//                Log.e("POKEMON_API", "Pokemons list loaded.")
//            }
//
//            override fun onFailure(call: Call<PokemonsApiResult>, t: Throwable) {
//                Log.e("POKEMON_API", "Error loading pokemons list", t)
//            }
//        })
//    }

}
}
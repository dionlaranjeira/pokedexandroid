package com.github.dionlaranjeira.pokedex_android.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.dionlaranjeira.pokedex_android.R
import com.github.dionlaranjeira.pokedex_android.api.PokemonRepository
import com.github.dionlaranjeira.pokedex_android.domain.Pokemon
import com.github.dionlaranjeira.pokedex_android.domain.PokemonType

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById<RecyclerView>(R.id.rvPokemons)
//
//        val bulbasaur =
//            Pokemon("https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png"
//                ,1,"Bulbasaur", listOf(
//                    PokemonType("Fire")
//                ));
//
//        val pokemons = listOf(
//            bulbasaur, bulbasaur, bulbasaur
//        )


        Thread(Runnable {
//            val pokemonsApi = PokemonRepository().listPokemons()
//            Log.d("Pokemon_API", pokemonsApi.toString())
            loadPokemons()
        }).start()



    }

    private fun loadPokemons() {
        val pokemonsApiResult = PokemonRepository().listPokemons()

        pokemonsApiResult?.results?.let {

            val layoutManager = LinearLayoutManager(this)

            recyclerView.post{
                recyclerView.layoutManager = layoutManager
                recyclerView.adapter = PokemonAdapter(it)
            }


        }

    }


}
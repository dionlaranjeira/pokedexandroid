package com.github.dionlaranjeira.pokedex_android.api.model

import com.github.dionlaranjeira.pokedex_android.domain.Pokemon
import com.github.dionlaranjeira.pokedex_android.domain.PokemonType

data class PokemonsApiResult (

    val count: Int,
    val next: String?,
    val previus: String?,
    val results: List<Pokemon>

    )



data class PokemonApiResult(
    val id: Int,
    val name: String,
    val types: PokemonTypeSlot
)

data class PokemonTypeSlot(
    val slot: Int,
    val type: PokemonType
)
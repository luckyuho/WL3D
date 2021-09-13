package com.hi.dhl.wl3d.data.repository

import androidx.paging.PagingData
import com.hi.dhl.wl3d.data.remote.PokemonResult
import com.hi.dhl.wl3d.model.PokemonInfoModel
import com.hi.dhl.wl3d.model.PokemonItemModel
import kotlinx.coroutines.flow.Flow

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/7/11
 *     desc  :
 * </pre>
 */
interface Repository {
    fun fetchPokemonList(): Flow<PagingData<PokemonItemModel>>

    fun fetchPokemonInfo(url: String): Flow<PokemonResult<PokemonInfoModel>>

    suspend fun fetchPokemonByParameter(parameter: String): Flow<PagingData<PokemonItemModel>>
}
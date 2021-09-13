package com.hi.dhl.wl3d.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.hi.dhl.wl3d.data.entity.PokemonEntity
import com.hi.dhl.wl3d.data.local.AppDataBase
import com.hi.dhl.wl3d.data.mapper.Mapper
import com.hi.dhl.wl3d.data.remote.PokemonResult
import com.hi.dhl.wl3d.data.remote.PokemonService
import com.hi.dhl.wl3d.model.PokemonInfoModel
import com.hi.dhl.wl3d.model.PokemonItemModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

/**
 * <pre>
 *     author: dhl
 *     date  : 2020/7/11
 *     desc  :
 * </pre>
 */

class PokemonRepositoryImpl(
    val api: PokemonService,
    val db: AppDataBase,
    val pageConfig: PagingConfig,
    val mapper2ItemMolde: Mapper<PokemonEntity, PokemonItemModel>,
//    val mapper2InfoModel: Mapper<PokemonInfoEntity, PokemonInfoModel>
    val mapper2InfoModel: Mapper<PokemonEntity, PokemonInfoModel>
) : Repository {

    override fun fetchPokemonList(): Flow<PagingData<PokemonItemModel>> {
        return Pager(
            config = pageConfig,
            remoteMediator = PokemonRemoteMediator(api, db)
        ) {
            db.pokemonDao().getPokemon()
        }.flow.map { pagingData ->
            pagingData.map { mapper2ItemMolde.map(it) }
        }
    }

    override fun fetchPokemonInfo(url: String): Flow<PokemonResult<PokemonInfoModel>> {
        return flow {
            try {
//                Log.d("NeededURLInformation", "In override suspend fun fetchPokemonInfo $url")
//                val pokemonDao = db.pokemonInfoDao()
                val pokemonDao = db.pokemonDao()
                // 查询数据库是否存在，如果不存在请求网络
                val infoModel = pokemonDao.getPokemonInfo(url)

//                Log.d("NeededURLInformation", infoModel.toString())
//                if (infoModel == null) {
//                    // 网络请求
//                    val netWorkPokemonInfo = api.fetchPokemonInfo(name)
//
//                    // 将网路请求的数据，换转成的数据库的 model，之后插入数据库
//                    infoModel = PokemonInfoEntity.convert2PokemonInfoEntity(netWorkPokemonInfo)
//                    // 插入更新数据库
//                    pokemonDao.insertPokemon(infoModel)
//                }
                // 将数据源的 model 转换成上层用到的 model，
                // ui 不能直接持有数据源，防止数据源的变化，影响上层的 ui
                val model = mapper2InfoModel.map(infoModel)

                // 发射转换后的数据
                emit(PokemonResult.Success(model))
            } catch (e: Exception) {
                emit(PokemonResult.Failure(e.cause))
            }
        }.flowOn(Dispatchers.IO) // 通过 flowOn 切换到 io 线程
    }

    override suspend fun fetchPokemonByParameter(parameter: String): Flow<PagingData<PokemonItemModel>> {
        return Pager(pageConfig) {
            // 加载数据库的数据
            db.pokemonDao().pokemonInfoByParameter(parameter)
        }.flow.map { pagingData ->

            // 数据映射，数据库实体 PersonEntity ——>  上层用到的实体 Person
            pagingData.map { mapper2ItemMolde.map(it) }
        }
    }

    companion object {
        private val TAG = "PokemonRepositoryImpl"
    }
}
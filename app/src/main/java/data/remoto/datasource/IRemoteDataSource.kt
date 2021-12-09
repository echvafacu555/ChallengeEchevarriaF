package data.remoto.datasource

import data.remoto.ObjectResult
import ui.ResponseAppApi

interface IRemoteDataSource {
    suspend fun getPopularPeliculas(): ObjectResult<ResponseAppApi>

}
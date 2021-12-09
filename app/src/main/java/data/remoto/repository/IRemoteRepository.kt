package data.remoto.repository

import data.remoto.ObjectResult
import ui.ResponseAppApi

interface IRemoteRepository {
    suspend fun getPopularPeliculas(): ObjectResult<ResponseAppApi>

}
package data.remoto.datasource

import android.content.Context
import data.remoto.MoviesApiClient
import model.toResponseAppApi
import data.remoto.ObjectResult
import ui.ResponseAppApi


class RemoteDataSource(context: Context): IRemoteDataSource {


    override suspend fun getPopularPeliculas(): ObjectResult<ResponseAppApi> {
        val appApi = MoviesApiClient.build()

        return try {
            val response = appApi.getPopularPeliculas()
            if (response.isSuccessful) {
                val body = response.body()
                ObjectResult.Success(body?.toResponseAppApi() ?: ResponseAppApi())
            } else {
                ObjectResult.Failure(Exception(response.errorBody()?.toString()))
            }
        } catch (ex: java.lang.Exception) {
            ObjectResult.Failure(ex)
        }
    }
}
package data.remoto.repository

import data.remoto.datasource.IRemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import data.remoto.ObjectResult
import model.PeliculaApi
import ui.ResponseAppApi

class RemoteRepository (val remoteDataSource: IRemoteDataSource): IRemoteRepository {
    override suspend fun getPopularPeliculas(): ObjectResult<ResponseAppApi> =
        withContext(Dispatchers.IO) {
            when (val result = this@RemoteRepository.remoteDataSource.getPopularPeliculas()) {
                is ObjectResult.Success -> ObjectResult.Success(result.data)
                is ObjectResult.Failure -> ObjectResult.Failure(result.exception)
            }
        }


    // Appel de la méthode searchMoviesApi (dans le repositery)
    /*fun searchMovieApi(query: String, pageNumber: Int) {
        mQuery = query
      //  mPageNumber = pageNumber
        PeliculaApi.searchMoviesApi(query, pageNumber)
    }*/


}
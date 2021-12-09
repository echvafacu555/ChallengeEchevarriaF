package usecases

import data.remoto.ObjectResult
import data.remoto.repository.RemoteRepository
import ui.ResponseAppApi

class PeliculaUseCases(val remoteRepository: RemoteRepository) {
    suspend fun getPopularPeliculas():
            ObjectResult<ResponseAppApi> = this.remoteRepository.getPopularPeliculas()
}
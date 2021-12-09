package data.remoto

import model.PeliculaResponse
import model.ResponseApi
import okhttp3.Response
import retrofit2.Call
import retrofit2.http.GET
const val IMG_BASE="https://image.tmdb.org/t/p/w342"



interface IServiceApiClient {
   // @GET("movie/popular?api_key=e2938d15948627e65b9fb87f239157f4")
    @GET( "movie/popular?api_key=e2938d15948627e65b9fb87f239157f4&page=1")
    suspend fun getPopularPeliculas(): retrofit2.Response<ResponseApi>
}
package data.remoto

import model.PeliculaResponse
import model.ResponseApi
import okhttp3.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

const val IMG_BASE="https://image.tmdb.org/t/p/w342"

const val  page=3

interface IServiceApiClient {
    //@GET("movie/popular?api_key=e2938d15948627e65b9fb87f239157f4&page="+page)

    @GET( "movie/popular?api_key=e2938d15948627e65b9fb87f239157f4&page=page")

 //   @GET("movie/popular?api_key=e2938d15948627e65b9fb87f239157f4&page="+page)


   /* open fun getPopularPeliculas(
        @Query("movie/popular?api_key=e2938d15948627e65b9fb87f239157f4&page=2")
        api_key: String?

    ): retrofit2.Response<ResponseApi>
*/
    suspend fun getPopularPeliculas(): retrofit2.Response<ResponseApi>






}
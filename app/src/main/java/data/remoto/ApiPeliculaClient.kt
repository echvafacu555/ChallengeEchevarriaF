package data.remoto

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MoviesApiClient {
    private lateinit var serviceApiInterface: IServiceApiClient

    fun build(): IServiceApiClient {
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create()
            )

        val httpClientBuilder = OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor())
        }

        val retrofit = retrofitBuilder.client(httpClientBuilder.build()).build()

        this.serviceApiInterface = retrofit.create(IServiceApiClient::class.java)

        return this.serviceApiInterface
    }

    private fun interceptor(): HttpLoggingInterceptor =  HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }
}
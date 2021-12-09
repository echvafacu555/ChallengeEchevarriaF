package model

import ui.Pelicula
import ui.ResponseAppApi


data class ResponseApi(val results: List<PeliculaResponse>)
//data class PeliculaResponse(val original_title: String, val poster_path:String)
data class PeliculaResponse(val original_title: String, val poster_path: String,
                            val original_language:String,
                            val vote_average: String, val release_date: String,val overview: String)



fun ResponseApi.toResponseAppApi(): ResponseAppApi = ResponseAppApi(this.results.toMoviesList())
fun List<PeliculaResponse>.toMoviesList(): List<Pelicula> = this.map { Pelicula(it.original_title,
    it.poster_path, it.original_language,it.vote_average,it.release_date, it.overview) }
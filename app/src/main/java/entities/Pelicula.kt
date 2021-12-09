package ui


data class ResponseAppApi(val results: List<Pelicula> ?= emptyList())
/*data class Pelicula(val id: String,val title: String, val poster_path:String, val release_date
:String )
*/

//data class Pelicula(val title: String)

data class Pelicula(val title: String, val poster_path:String, val original_language:String,
                    val vote_average: String, val release_date: String, val overview: String)
//falta genero


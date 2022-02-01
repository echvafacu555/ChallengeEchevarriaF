package viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import data.remoto.ObjectResult
import data.remoto.repository.RemoteRepository
import ui.Pelicula
import usecases.PeliculaUseCases

class ViewModelDemo (private val peliculaUseCases: PeliculaUseCases): ViewModel() {

    private val mOnError = MutableLiveData<String>()
    val onError: LiveData<String> = mOnError

    private val mListPeliculas = MutableLiveData<List<Pelicula>>()
    val listPeliculas: LiveData<List<Pelicula>> = mListPeliculas


    // Appel de la méthode searchMoviesApi (dans le modèle de vue)
    /*fun searchMovieApi(query: String?, pageNumber: Int) {
        RemoteRepository.searchMovieApi(query, pageNumber)
    }*/

    fun getPopularPeliculas(){
        viewModelScope.launch {
            when(val result = this@ViewModelDemo.peliculaUseCases.getPopularPeliculas()){
                is ObjectResult.Success -> this@ViewModelDemo.mListPeliculas.value = result.data.results
                is ObjectResult.Failure -> this@ViewModelDemo.mOnError.value = result.exception.message
            }
        }
    }

   /* fun searchNextPage() {
        RemoteRepository.searchNextPage();
    }*/
}
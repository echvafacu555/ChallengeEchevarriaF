package viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import usecases.PeliculaUseCases

class ViewModelFactory(private val
                       peliculaUseCases: PeliculaUseCases): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T
    = ViewModelDemo(peliculaUseCases) as T
}

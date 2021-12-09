package ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels

import echevasoft.challengeechevarriaf.databinding.ActivityMainBinding
import data.remoto.datasource.RemoteDataSource
import data.remoto.repository.RemoteRepository
import echevasoft.challengeechevarriaf.R
import extensions.addOnScrolledToEnd
import kotlinx.android.synthetic.main.activity_main.*

import usecases.PeliculaUseCases
import viewmodel.ViewModelDemo
import viewmodel.ViewModelFactory



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<ViewModelDemo> {


        val remoteRepository = RemoteRepository(RemoteDataSource(this))
        ViewModelFactory(PeliculaUseCases(remoteRepository)
        )
    }

  //private val adapter: PeliculaAdapter by lazy { PeliculaAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()
        callViewModelMethods()
        viewModelObservers()
        initRecycler()


      final()




    }
    private val adapter: PeliculaAdapter by lazy { PeliculaAdapter() }

    private fun bind(){
        this.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(this.binding.root)
    }

    fun final(){

        rv_peliculas.addOnScrolledToEnd {



            Toast.makeText(this,"finaaaal",Toast.LENGTH_LONG).show()
        }


    }
    private fun callViewModelMethods(){
        this.viewModel.getPopularPeliculas()
    }


    private fun viewModelObservers(){
        this.viewModel.onError.observe(this,{
            //lo que debe hacer si es que detecta algun error
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
        this.viewModel.listPeliculas.observe(this, {
            this.adapter.list = it
        })
    }

    private fun initRecycler(){
        this.binding.rvPeliculas.adapter = this.adapter
        this.adapter.peliculaClick = {
            val intent = Intent(this, Detalle_Pelicula::class.java)
            intent.putExtra("title",it.title.toString())
            intent.putExtra("poster_path",it.poster_path)
            intent.putExtra("original_language",it.original_language)
            intent.putExtra("vote_average",it.vote_average.toString())
            intent.putExtra("release_date",it.release_date)
            intent.putExtra("overview",it.overview)

            startActivity(intent)
        }

    }




}











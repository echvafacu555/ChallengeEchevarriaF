package ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import data.remoto.IMG_BASE
import echevasoft.challengeechevarriaf.R
import echevasoft.challengeechevarriaf.databinding.ActivityDetallePeliculaBinding
import retrofit2.http.GET

class Detalle_Pelicula : AppCompatActivity() {
    private lateinit var binding: ActivityDetallePeliculaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)

        bind()
        tomarValor()
    }
    private fun bind(){

        binding = ActivityDetallePeliculaBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    private fun tomarValor() {
        //var bundle :Bundle ?=intent.extras
        val extras = intent.extras
        var title = extras?.getString("title")
        var poster_path = extras?.getString("poster_path")
        var original_language=extras?.getString("original_language")
        var vote_average = extras?.getString("vote_average")
        var release_date = extras?.getString("release_date")
        var overview = extras?.getString("overview")


        binding.detalleTitle.setText(title)
        binding.originalLanguage.setText("Lenguaje original: "+original_language)
        binding.voteAverage.setText("Rating: "+vote_average)
        binding.releaseDate.setText("Fecha de lanzamiento: "+release_date)
        binding.overview.setText(overview)

Glide.with(this).load(IMG_BASE+poster_path).into(binding.detallePosterPath)


    }


}
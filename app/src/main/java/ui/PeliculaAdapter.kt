package ui

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import data.remoto.IMG_BASE
import echevasoft.challengeechevarriaf.databinding.ItemBinding
import kotlinx.android.synthetic.main.activity_detalle_pelicula.view.*
import java.util.*



typealias PeliculaClick = (pelicula: Pelicula) -> Unit
class PeliculaAdapter :RecyclerView.Adapter<PeliculaAdapter.PeliculaViewHolder>() {


    var list: List<Pelicula> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    var peliculaClick: PeliculaClick? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int


    ): PeliculaAdapter.PeliculaViewHolder = PeliculaViewHolder(
        ItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )


    )

    override fun onBindViewHolder(holder: PeliculaAdapter.PeliculaViewHolder, position: Int) {
        holder.bind(this.list[position])


    }

    override fun getItemCount(): Int = this.list.size


    inner class PeliculaViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(pelicula: Pelicula) {
            binding.apply {
                this.tituloPelicula.text = pelicula.title
                Glide.with(detallePosterPath).load(IMG_BASE + pelicula.poster_path)
                    .into(detallePosterPath.detalle_poster_path)

                // this.titulo_pelicula.text = pelicula.title
                this.tituloPelicula.setOnClickListener() {
                    this@PeliculaAdapter.peliculaClick?.let {
                        it(pelicula)
                    }
                }
            }
        }

    }


}
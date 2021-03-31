package ru.mrsu.catsapp.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.mrsu.catsapp.R
import ru.mrsu.catsapp.model.Cat

/**
 * @author Arthur Korchagin (arth.korchagin@gmail.com)
 * @since 30.03.21
 */
class CatItemVH(
    view: View,
    val onCatClickListener: (Cat) -> Unit
) : RecyclerView.ViewHolder(view) {

    private val ivCat = itemView.findViewById<ImageView>(R.id.ivCat)
    private val tvDescription = itemView.findViewById<TextView>(R.id.tvDescription)
    private val tvName = itemView.findViewById<TextView>(R.id.tvName)

    private var cat: Cat? = null

    init {
        itemView.setOnClickListener {
            cat?.let {
                onCatClickListener(it)
            }
        }
    }

    fun bind(cat: Cat) {
        this.cat = cat
        ivCat.setImageResource(cat.avatar)
        tvDescription.text = cat.description
        tvName.text = cat.name
    }

}
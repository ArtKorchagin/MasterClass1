package ru.mrsu.catsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.mrsu.catsapp.R
import ru.mrsu.catsapp.model.Cat

/**
 * @author Arthur Korchagin (arth.korchagin@gmail.com)
 * @since 30.03.21
 */
class CatsAdapter(
    val catsList: List<Cat>,
    val onCatClickListener: (Cat) -> Unit
) : RecyclerView.Adapter<CatItemVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatItemVH {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_cat, parent, false)
        return CatItemVH(view, onCatClickListener)
    }

    override fun onBindViewHolder(holder: CatItemVH, position: Int) {
        holder.bind(catsList[position])
    }

    override fun getItemCount(): Int = catsList.size
}
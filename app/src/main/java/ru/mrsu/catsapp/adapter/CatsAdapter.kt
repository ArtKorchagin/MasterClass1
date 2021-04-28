package ru.mrsu.catsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.mrsu.catsapp.R
import ru.mrsu.catsapp.databinding.ItemCatBinding
import ru.mrsu.catsapp.model.Cat

/**
 * @author Arthur Korchagin (arth.korchagin@gmail.com)
 * @since 30.03.21
 */
class CatsAdapter(
    var catsList: List<Cat> = emptyList(),
    val onCatClickListener: (Cat) -> Unit
) : RecyclerView.Adapter<CatItemVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatItemVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemCatBinding.inflate(layoutInflater, parent, false)
        return CatItemVH(binding, onCatClickListener)
    }

    override fun onBindViewHolder(holder: CatItemVH, position: Int) {
        holder.bind(catsList[position])
    }

    override fun getItemCount(): Int = catsList.size
}
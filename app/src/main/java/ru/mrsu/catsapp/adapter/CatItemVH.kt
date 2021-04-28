package ru.mrsu.catsapp.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.mrsu.catsapp.R
import ru.mrsu.catsapp.databinding.ItemCatBinding
import ru.mrsu.catsapp.model.Cat

/**
 * @author Arthur Korchagin (arth.korchagin@gmail.com)
 * @since 30.03.21
 */
class CatItemVH(
    private val binding: ItemCatBinding,
    val onCatClickListener: (Cat) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

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
        Glide.with(itemView)
            .load(cat.avatar)
            .placeholder(R.drawable.ic_cat_placeholder)
            .error(R.drawable.ic_cat_placeholder)
            .into(binding.ivCat)
        binding.tvDescription.text = cat.description
        binding.tvName.text = cat.name
    }

}
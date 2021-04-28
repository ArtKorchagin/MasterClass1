package ru.mrsu.catsapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

/**
 * @author Arthur Korchagin (arth.korchagin@gmail.com)
 * @since 30.03.21
 */
class CatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.ac_cat)

        val ivCat = findViewById<ImageView>(R.id.ivCat)
        val tvDescription = findViewById<TextView>(R.id.tvDescription)
        val tvName = findViewById<TextView>(R.id.tvName)

        val name = intent.getStringExtra("name")
        val description = intent.getStringExtra("description")
        val avatar = intent.getStringExtra("avatar")

        Glide.with(this)
            .load(avatar)
            .placeholder(R.drawable.ic_cat_placeholder)
            .into(ivCat)

        tvDescription.text = description
        tvName.text = name
    }

}
package ru.mrsu.catsapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

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
        val avatar = intent.getIntExtra("avatar", -1)

        ivCat.setImageResource(avatar)
        tvDescription.text = description
        tvName.text = name
    }

}
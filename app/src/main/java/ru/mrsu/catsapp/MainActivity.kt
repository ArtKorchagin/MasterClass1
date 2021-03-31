package ru.mrsu.catsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.mrsu.catsapp.adapter.CatsAdapter
import ru.mrsu.catsapp.model.Cat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    val catImages = listOf<Int>(
        R.drawable.cat_1,
        R.drawable.cat_2,
        R.drawable.cat_3,
        R.drawable.cat_4,
        R.drawable.cat_5,
        R.drawable.cat_6,
        R.drawable.cat_7,
        R.drawable.cat_8,
        R.drawable.cat_9,
        R.drawable.cat_10,
        R.drawable.cat_11,
        R.drawable.cat_12,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvList = findViewById<RecyclerView>(R.id.rvList)

        rvList.layoutManager = LinearLayoutManager(this)
        rvList.adapter = CatsAdapter(generateCats()) {
            val intent = Intent(this, CatActivity::class.java)
            intent.putExtra("name", it.name)
            intent.putExtra("description", it.description)
            intent.putExtra("avatar", it.avatar)
            startActivity(intent)
        }
    }

    private fun generateCats(): List<Cat> {
        return catImages.map { resId ->
                Cat(
                    avatar = resId,
                    name = generateName(5),
                    description =  generateName(50)
                )
            }
    }

    private fun generateName(count : Int): String {
        return generateSequence {
            Random.nextInt('a'.toInt(), 'z'.toInt()).toChar()
        }
            .take(count)
            .joinToString(separator = "")
    }

}
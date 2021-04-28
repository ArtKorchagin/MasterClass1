package ru.mrsu.catsapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.mrsu.catsapp.adapter.CatsAdapter
import ru.mrsu.catsapp.databinding.ActivityMainBinding
import ru.mrsu.catsapp.model.Cat

class MainActivity : AppCompatActivity() {

    private val catsAdapter: CatsAdapter by lazy {
        CatsAdapter {
            val intent = Intent(this, CatActivity::class.java)
            intent.putExtra("name", it.name)
            intent.putExtra("description", it.description)
            intent.putExtra("avatar", it.avatar)
            startActivity(intent)
        }
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvList.layoutManager = LinearLayoutManager(this)
        binding.rvList.adapter = catsAdapter
        binding.fabCreateCat.setOnClickListener {
            startActivity(Intent(this, CreateCatActivity::class.java))
            finish()
        }
        loadCats()
    }

    private fun loadCats() {
        setLoading(true)
        return NetworkService
            .loadCats()
            .enqueue(object : Callback<List<Cat>> {
                override fun onResponse(call: Call<List<Cat>>, response: Response<List<Cat>>) {
                    setLoading(false)
                    catsAdapter.catsList = response.body() ?: emptyList()
                    catsAdapter.notifyDataSetChanged()
                }

                override fun onFailure(call: Call<List<Cat>>, t: Throwable) {
                    setError(t.message ?: getString(R.string.something_wrong))
                }
            })
    }

    private fun setError(errorText: String) {
        binding.progressIndicator.isVisible = false
        binding.lError.isVisible = true
        binding.tvError.text = errorText
        binding.btnRepeat.setOnClickListener {
            loadCats()
        }
    }

    private fun setLoading(isLoading: Boolean) {
        binding.lError.isVisible = false
        binding.progressIndicator.isVisible = isLoading
        binding.rvList.isVisible = !isLoading
    }


}
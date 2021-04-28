package ru.mrsu.catsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.mrsu.catsapp.databinding.AcCreateCatBinding
import ru.mrsu.catsapp.model.Cat

/**
 * @author Arthur Korchagin (arth.korchagin@gmail.com)
 * @since 27.04.21
 */
class CreateCatActivity : AppCompatActivity() {


    private lateinit var binding: AcCreateCatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AcCreateCatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCreate.setOnClickListener {
            createCat()
        }
    }

    private fun createCat() {
        val name = binding.etName.text.toString()
        val description = binding.etDescription.text.toString()

        if (name.isNullOrBlank() || description.isNullOrBlank()) {
            Toast
                .makeText(this, getString(R.string.fill_fields), Toast.LENGTH_LONG)
                .show()
            return
        }

        setLoading(true)

        NetworkService.sendCat(
            Cat(
                name,
                description,
                ""
            )
        ).enqueue(object : Callback<Cat> {
            override fun onResponse(call: Call<Cat>, response: Response<Cat>) {
                Toast
                    .makeText(
                        this@CreateCatActivity,
                        getString(R.string.cat_created),
                        Toast.LENGTH_LONG
                    )
                    .show()
                startActivity(Intent(this@CreateCatActivity, MainActivity::class.java))
                finish()
            }

            override fun onFailure(call: Call<Cat>, t: Throwable) {
            }

        })
    }


    private fun setLoading(isLoading: Boolean) {
        binding.btnCreate.isVisible = !isLoading
        binding.progressIndicator.isVisible = isLoading
    }


}
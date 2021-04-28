package ru.mrsu.catsapp

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.mrsu.catsapp.model.Cat

/**
 * @author Arthur Korchagin (arth.korchagin@gmail.com)
 * @since 27.04.21
 */
object NetworkService {
    private val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okhttpClient = OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .build()

    private val retrofit = Retrofit.Builder()
        .client(okhttpClient)
        .baseUrl("https://6088292fa6f4a30017425d5a.mockapi.io/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val catsApi = retrofit.create(CatsApi::class.java)

    fun loadCats() = catsApi.loadCats()

    fun sendCat(cat: Cat) = catsApi.sendCat(cat)
}
package ru.mrsu.catsapp

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import ru.mrsu.catsapp.model.Cat

/**
 * @author Arthur Korchagin (arth.korchagin@gmail.com)
 * @since 27.04.21
 */
interface CatsApi {
    @GET("/cats")
    fun loadCats(): Call<List<Cat>>

    @POST("/cats")
    fun sendCat(@Body cat : Cat): Call<Cat>
}
package ru.mrsu.catsapp.model

import androidx.annotation.DrawableRes

/**
 * @author Arthur Korchagin (arth.korchagin@gmail.com)
 * @since 30.03.21
 */
data class Cat(
    val name : String,
    val description: String,
    val avatar: String,
)
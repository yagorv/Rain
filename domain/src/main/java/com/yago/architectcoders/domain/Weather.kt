package com.yago.architectcoders.domain

data class Weather(
    val id: Int,
    val image: String,
    val date: String,
    val description: String,
    val windDirection: String,
    val clouds: Int,
)
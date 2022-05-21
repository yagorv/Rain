package com.yago.architectcoders.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DbWeather(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    val image: String,
    val date: String,
    val description: String,
    val windDirection: String,
    val clouds: Int,
)
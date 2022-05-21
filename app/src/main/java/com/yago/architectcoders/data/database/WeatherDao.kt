package com.yago.architectcoders.data.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {

    @Query("SELECT * FROM DbWeather")
    fun getAll(): Flow<List<DbWeather>>

    @Query("SELECT * FROM DbWeather WHERE id = :id")
    fun findById(id: Int): Flow<DbWeather>

    @Query("SELECT COUNT(id) FROM DbWeather")
    suspend fun weatherCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeathers(dbWeathers: List<DbWeather>)
}
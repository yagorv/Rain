package com.yago.architectcoders.data.server

import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteService {

    @GET("forecast/daily")
    suspend fun listPopularWeathers(
        @Query("key") apiKey: String,
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("lang") lang: String? = "es"
    ): RemoteResult

}
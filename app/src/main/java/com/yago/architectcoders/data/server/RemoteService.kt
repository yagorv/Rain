package com.yago.architectcoders.data.server

import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteService {

    @GET("daily?city=Muros,ES")
    suspend fun listPopularWeathers(
        @Query("key") apiKey: String,
        @Query("lang") lang: String? = "es"
    ): RemoteResult

}
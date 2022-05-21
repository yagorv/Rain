package com.yago.architectcoders.usecases

import com.yago.architectcoders.data.WeathersRepository
import com.yago.architectcoders.domain.Weather
import kotlinx.coroutines.flow.Flow

class FindWeatherUseCase(private val repository: WeathersRepository) {

    operator fun invoke(id: Int): Flow<Weather> = repository.findById(id)
}
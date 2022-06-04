package com.yago.architectcoders.usecases

import com.yago.architectcoders.domain.Error
import com.yago.architectcoders.data.WeathersRepository

class RequestForecastWeathersUseCase(private val weathersRepository: WeathersRepository) {

    suspend operator fun invoke(): Error? {
        return weathersRepository.requestForecastWeather()
    }
}
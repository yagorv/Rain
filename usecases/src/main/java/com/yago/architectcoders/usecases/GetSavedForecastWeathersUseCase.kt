package com.yago.architectcoders.usecases

import com.yago.architectcoders.data.WeathersRepository

class GetSavedForecastWeathersUseCase(private val repository: WeathersRepository) {

    operator fun invoke() = repository.forecastWeathers
}
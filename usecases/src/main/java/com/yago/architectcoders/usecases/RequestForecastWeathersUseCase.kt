package com.yago.architectcoders.usecases

import com.yago.architectcoders.domain.Error
import com.yago.architectcoders.data.WeathersRepository

class RequestPopularWeathersUseCase(private val weathersRepository: WeathersRepository) {

    suspend operator fun invoke(): Error? {
        return weathersRepository.requestPopularWeathers()
    }
}
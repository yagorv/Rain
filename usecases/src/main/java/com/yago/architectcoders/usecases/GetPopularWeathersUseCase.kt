package com.yago.architectcoders.usecases

import com.yago.architectcoders.data.WeathersRepository

class GetPopularWeathersUseCase(private val repository: WeathersRepository) {

    operator fun invoke() = repository.popularWeathers
}
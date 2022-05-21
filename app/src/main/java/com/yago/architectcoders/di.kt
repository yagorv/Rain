package com.yago.architectcoders

import android.app.Application
import androidx.room.Room
import com.yago.architectcoders.data.WeathersRepository
import com.yago.architectcoders.data.database.WeatherDatabase
import com.yago.architectcoders.data.database.WeatherRoomDataSource
import com.yago.architectcoders.data.datasource.WeatherLocalDataSource
import com.yago.architectcoders.data.datasource.WeatherRemoteDataSource
import com.yago.architectcoders.data.server.WeatherServerDataSource
import com.yago.architectcoders.ui.detail.DetailViewModel
import com.yago.architectcoders.ui.main.MainViewModel
import com.yago.architectcoders.usecases.GetPopularWeathersUseCase
import com.yago.architectcoders.usecases.RequestPopularWeathersUseCase
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun Application.initDi() {
    startKoin {
        androidLogger(level = Level.ERROR)
        androidContext(this@initDi)
        modules(appModule, dataModule, usesCasesModule)
    }
}

private val appModule = module {

    single(named("apiKey")) { androidContext().getString(R.string.api_key) }

    single {
        Room.databaseBuilder(
            get(),
            WeatherDatabase::class.java, "weather-db"
        ).build()
    }

    single { get<WeatherDatabase>().weatherDao() }

    factory<WeatherLocalDataSource> { WeatherRoomDataSource(get()) }
    factory<WeatherRemoteDataSource> { WeatherServerDataSource(get(named("apiKey"))) }

    viewModel { MainViewModel(get(), get()) }
    viewModel { (id: Int) -> DetailViewModel(id, get()) }
}

private val dataModule = module {
    factory { WeathersRepository(get(), get()) }
}

private val usesCasesModule = module {
    factory { GetPopularWeathersUseCase(get()) }
    factory { RequestPopularWeathersUseCase(get()) }
}
package com.yago.architectcoders

import android.app.Application
import androidx.room.Room
import com.yago.architectcoders.data.PlayServicesLocationDataSource
import com.yago.architectcoders.data.WeathersRepository
import com.yago.architectcoders.data.database.WeatherDatabase
import com.yago.architectcoders.data.database.WeatherRoomDataSource
import com.yago.architectcoders.data.datasource.LocationDataSource
import com.yago.architectcoders.data.datasource.WeatherLocalDataSource
import com.yago.architectcoders.data.datasource.WeatherRemoteDataSource
import com.yago.architectcoders.data.server.RemoteConnection
import com.yago.architectcoders.data.server.WeatherServerDataSource
import com.yago.architectcoders.ui.dayForecast.detail.DetailViewModel
import com.yago.architectcoders.ui.dayForecast.list.ListDayForecastViewModel
import com.yago.architectcoders.usecases.FindWeatherUseCase
import com.yago.architectcoders.usecases.GetSavedForecastWeathersUseCase
import com.yago.architectcoders.usecases.RequestForecastWeathersUseCase
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
    factory<WeatherRemoteDataSource> { WeatherServerDataSource(get(named("apiKey")), get()) }
    factory<LocationDataSource> { PlayServicesLocationDataSource(get()) }
    single { RemoteConnection(get()).service }

    viewModel { ListDayForecastViewModel(get(), get()) }
    viewModel { (id: Int) -> DetailViewModel(id, get()) }
}

private val dataModule = module {
    factory { WeathersRepository(get(), get(), get()) }
}

private val usesCasesModule = module {
    factory { GetSavedForecastWeathersUseCase(get()) }
    factory { RequestForecastWeathersUseCase(get()) }
    factory { FindWeatherUseCase(get()) }
}
package com.yago.architectcoders.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.yago.architectcoders.data.toError
import com.yago.architectcoders.domain.Weather
import com.yago.architectcoders.domain.Error
import com.yago.architectcoders.usecases.FindWeatherUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class DetailViewModel(
    weatherId: Int,
    findWeatherUseCase: FindWeatherUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            findWeatherUseCase(weatherId)
                .catch { cause -> _state.update { it.copy(error = cause.toError()) } }
                .collect { weather -> _state.update { UiState(weather = weather) } }
        }
    }

    data class UiState(val weather: Weather? = null, val error: Error? = null)
}

@Suppress("UNCHECKED_CAST")
class DetailViewModelFactory(
    private val weatherId: Int,
    private val findWeatherUseCase: FindWeatherUseCase,
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailViewModel(weatherId, findWeatherUseCase) as T
    }
}
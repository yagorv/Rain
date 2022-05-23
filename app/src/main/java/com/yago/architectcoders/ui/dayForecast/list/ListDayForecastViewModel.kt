package com.yago.architectcoders.ui.dayForecast.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yago.architectcoders.data.toError
import com.yago.architectcoders.domain.Error
import com.yago.architectcoders.domain.Weather
import com.yago.architectcoders.usecases.GetSavedForecastWeathersUseCase
import com.yago.architectcoders.usecases.RequestForecastWeathersUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class ListDayForecastViewModel(
    getSavedForecastWeathersUseCase: GetSavedForecastWeathersUseCase,
    private val requestForecastWeathersUseCase: RequestForecastWeathersUseCase
) :
    ViewModel() {

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            getSavedForecastWeathersUseCase()
                .catch { cause -> _state.update { it.copy(error = cause.toError()) } }
                .collect { weathers -> _state.update { UiState(weathers = weathers) } }
        }
    }

    fun onUiReady() {
        viewModelScope.launch {
            _state.value = _state.value.copy(loading = true)
            val error = requestForecastWeathersUseCase()
            _state.update { _state.value.copy(loading = false, error = error) }
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val weathers: List<Weather>? = null,
        val error: Error? = null
    )
}
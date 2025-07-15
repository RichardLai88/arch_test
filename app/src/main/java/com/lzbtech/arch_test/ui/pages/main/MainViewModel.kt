package com.lzbtech.arch_test.ui.pages.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lzbtech.arch_test.repository.api.weather.WeatherRepository
import com.lzbtech.arch_test.repository.model.DailyWeatherResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val weatherRepository: WeatherRepository) : ViewModel() {

    private val _count = mutableIntStateOf(0)
    val count: State<Int> = _count

    private val _weather = mutableStateOf<DailyWeatherResponse?>(null)
    val weather: State<DailyWeatherResponse?> = _weather

    init {
        fetchWeather()
    }

    fun increase() {
        _count.intValue += 1
    }

    fun fetchWeather() {
        viewModelScope.launch {
            val result = weatherRepository.getWeather()
            print("result: $result")
            _weather.value = result
        }
    }
}
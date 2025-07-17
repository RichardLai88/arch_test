package com.lzbtech.arch_test.repository.network

import com.lzbtech.arch_test.repository.model.DailyWeatherResponse
import retrofit2.http.GET

interface WeatherService {

    @GET("/v3/weather/weatherInfo?city=110101&key=<替换成高德的key就好了>")
    suspend fun getWeather(): DailyWeatherResponse
}

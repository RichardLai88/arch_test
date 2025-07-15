package com.lzbtech.arch_test.repository.network

object ServiceProvider {

    fun providerWeatherService(): WeatherService {
        return RetrofitProvider.build().create<WeatherService>(WeatherService::class.java)
    }
}
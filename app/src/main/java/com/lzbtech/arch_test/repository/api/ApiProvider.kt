package com.lzbtech.arch_test.repository.api

import com.lzbtech.arch_test.repository.api.weather.WeatherRepository
import com.lzbtech.arch_test.repository.api.weather.WeatherRepositoryImp
import com.lzbtech.arch_test.repository.network.ServiceProvider

object ApiProvider {

    fun providerWeatherRepository(): WeatherRepository {
        return WeatherRepositoryImp(ServiceProvider.providerWeatherService())
    }
}
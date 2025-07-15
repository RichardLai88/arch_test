package com.lzbtech.arch_test.repository.model

data class DailyWeatherResponse(
    val status: Int,
    val count: Int,
    val lives: List<Live>,
)

data class Live (
    val province: String,
    val city: String,
    val adcode: String,
    val weather: String,
    val temperature: String,
    val winddirection: String,
    val windpower: String,
    val humidity: String,
    val reporttime: String,
    val temperature_float: String,
    val humidity_float: String
)
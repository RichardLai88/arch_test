package com.lzbtech.arch_test.repository.model

data class HttpResponse<T>(
    val status: Int,
    val message: String,
    val data: T
)

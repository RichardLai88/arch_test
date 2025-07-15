package com.lzbtech.arch_test.ui.pages.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MainPage(modifier: Modifier) {
    val viewModel: MainViewModel = hiltViewModel()
    val count by remember { viewModel.count }
    val todayWeather by remember { viewModel.weather }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("今日天气：${todayWeather?.lives?.get(0)?.weather}")
        Spacer(Modifier.height(100.dp))
        Text(" 计数器: $count")
        Button(onClick = {
            viewModel.increase()
        }) {
            Text("加一")
        }
    }
}
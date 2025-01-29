package com.example.sharedflowstateflowtutorial.usecase1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class StockViewModel : ViewModel() {
    private var _stockPrice = MutableStateFlow(0.0)
    val stockPrice = _stockPrice.asStateFlow()

    init {
        viewModelScope.launch {
            updateStockPrice()
        }
    }

    private suspend fun updateStockPrice(){
        while (true){
            delay(1000)
            val newPrice = fetchNewPrice()
            _stockPrice.value = newPrice
        }
    }

    private suspend fun fetchNewPrice(): Double{
        return 3.0
    }
}
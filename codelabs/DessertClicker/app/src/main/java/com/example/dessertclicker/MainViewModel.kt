package com.example.dessertclicker

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource
import com.example.dessertclicker.model.Dessert
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(MainUIState())
    val uiState: StateFlow<MainUIState> = _uiState.asStateFlow()

    private val desserts = Datasource.dessertList
    private var currentDessertIndex by mutableStateOf(0)
    private var currentDessert: Dessert

    init {
        currentDessert = desserts[currentDessertIndex]
        _uiState.value = MainUIState(
            currentDessertPrice = currentDessert.price,
            currentDessertImageId = currentDessert.imageId
        )
    }

    fun updateDessert() {
        updateRevenueAndSellDessert()
        determineDessertToShow()
    }

    private fun updateRevenueAndSellDessert() {
        val price = _uiState.value.currentDessertPrice
        val updatedRevenue = _uiState.value.revenue.plus(price)
        val dessertsSold = _uiState.value.dessertsSold.plus(1)
        _uiState.update { currentState ->
            currentState.copy(
                revenue = updatedRevenue,
                dessertsSold = dessertsSold
            )
        }
    }

    private fun determineDessertToShow() {
        for (dessert in desserts) {
            if (uiState.value.dessertsSold >= dessert.startProductionAmount) {
                currentDessert = dessert
                _uiState.update { currentState ->
                    currentState.copy(
                        currentDessertPrice = currentDessert.price,
                        currentDessertImageId = currentDessert.imageId
                    )
                }
            } else {
                // The list of desserts is sorted by startProductionAmount. As you sell more desserts,
                // you'll start producing more expensive desserts as determined by startProductionAmount
                // We know to break as soon as we see a dessert who's "startProductionAmount" is greater
                // than the amount sold.
                break
            }
        }
    }
}
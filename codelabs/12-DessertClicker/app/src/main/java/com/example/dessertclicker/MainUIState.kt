package com.example.dessertclicker

// https://github.com/google-developer-training/basic-android-kotlin-compose-training-dessert-clicker/blob/viewmodel/app/src/main/java/com/example/dessertclicker/data/DessertUiState.kt
data class MainUIState (
    val revenue: Int = 0,
    val dessertsSold: Int = 0,
    val currentDessertPrice: Int = 0,
    val currentDessertImageId: Int = 0
)
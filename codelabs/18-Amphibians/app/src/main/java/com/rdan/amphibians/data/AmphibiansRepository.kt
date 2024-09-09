package com.rdan.amphibians.data

import com.rdan.amphibians.network.Amphibian
import com.rdan.amphibians.network.AmphibiansApiService

interface AmphibiansRepository {
    suspend fun getAmphibians(): List<Amphibian>
}

class NetworkAmphibiansRepository(
    private val apiService: AmphibiansApiService
): AmphibiansRepository {
    override suspend fun getAmphibians(): List<Amphibian> = apiService.getAmphibians()
}
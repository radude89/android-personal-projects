package com.example.marsphotos.fake

import MarsApiService
import com.example.marsphotos.network.MarsPhoto

class FakeMarsApiService : MarsApiService {
    override suspend fun getPhotos(): List<MarsPhoto> {
        return FakeDataSource.photosList
    }
}
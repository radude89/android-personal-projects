/*
 * Copyright (C) 2021 The Android Open Source Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.waterme.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.work.*
import com.example.waterme.data.DataSource
import com.example.waterme.model.Plant
import com.example.waterme.worker.WaterReminderWorker
import java.util.concurrent.TimeUnit

class PlantViewModel(application: Application): ViewModel() {

    val plants = DataSource.plants

    private val workManager = WorkManager.getInstance(application)

    internal fun scheduleReminder(
        duration: Long,
        unit: TimeUnit,
        plantName: String
    ) {
        val notificationRequest = OneTimeWorkRequestBuilder<WaterReminderWorker>()
            .setInputData(
                Data.Builder().putString(WaterReminderWorker.nameKey, plantName).build()
            )
            .setInitialDelay(duration, unit)
            .build()

        val work = workManager.beginUniqueWork(
            "Schedule reminder",
            ExistingWorkPolicy.REPLACE,
            notificationRequest
        )

        work.enqueue()
    }
}

class PlantViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(PlantViewModel::class.java)) {
            PlantViewModel(application) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
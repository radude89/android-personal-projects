package com.example.busschedule.data

import androidx.room.Dao
import androidx.room.Query

@Dao
interface BusScheduleDao {
    @Query("SELECT * FROM schedules")
    suspend fun getAll(): List<BusSchedule>
}

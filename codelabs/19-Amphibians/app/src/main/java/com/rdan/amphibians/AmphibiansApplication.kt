package com.rdan.amphibians

import android.app.Application
import com.rdan.amphibians.data.AppContainer
import com.rdan.amphibians.data.DefaultAppContainer

class AmphibiansApplication: Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}
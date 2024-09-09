package com.rdan.amphibians

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.rdan.amphibians.ui.AmphibiansApp
import com.rdan.amphibians.ui.theme.AmphibiansTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AmphibiansTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) {
                    AmphibiansApp()
                }
            }
        }
    }
}
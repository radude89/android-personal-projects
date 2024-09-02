package com.rdan.amphibians

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
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
                    AmphibianCard()
                }
            }
        }
    }
}

@Composable
private fun AmphibianCard(modifier: Modifier = Modifier) {
    Card {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
        ) {
            Text(text = "Title")
            Image(
                painter = painterResource(
                    R.drawable.ic_launcher_foreground
                ),
                contentDescription = null
            )
            Text(text = "Content")
        }
    }
}
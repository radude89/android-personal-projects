package com.rdan.amphibians.ui

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.rdan.amphibians.R
import com.rdan.amphibians.ui.screens.AmphibianListScreen

@Composable
fun AmphibiansApp() {
    Scaffold(
        topBar = {
            AmphibiansTopBar()
        }
    ) { it ->
        AmphibianListScreen(it)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AmphibiansTopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.titleLarge
            )
        }
    )
}
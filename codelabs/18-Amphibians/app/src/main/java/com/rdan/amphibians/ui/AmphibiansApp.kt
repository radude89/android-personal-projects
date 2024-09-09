package com.rdan.amphibians.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rdan.amphibians.R
import com.rdan.amphibians.network.Amphibian
import com.rdan.amphibians.network.mockedAmphibians
import com.rdan.amphibians.ui.theme.AmphibiansTheme

@Composable
fun AmphibiansApp() {
    Scaffold(
        topBar = {
            AmphibiansTopBar()
        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(mockedAmphibians) {
                AmphibianCard(
                    amphibian = it,
                    modifier = Modifier
                        .padding(dimensionResource(R.dimen.padding_small))
                )
            }
        }
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

@Composable
private fun AmphibianCard(
    amphibian: Amphibian,
    modifier: Modifier
) {
    Card(
        modifier = modifier
            .padding(dimensionResource(R.dimen.padding_small)),
        shape = MaterialTheme.shapes.small,
        elevation = CardDefaults.cardElevation(
            dimensionResource(R.dimen.card_elevation)
        )
    ) {
        Column {
            Title(amphibian, modifier)
            MainImage(amphibian, modifier)
            ContentDescription(amphibian, modifier)
        }
    }
}

@Composable
private fun Title(
    amphibian: Amphibian,
    modifier: Modifier = Modifier
) {
    Text(
        "${amphibian.name} (${amphibian.type})",
        style = MaterialTheme.typography.titleLarge,
        modifier = modifier
            .padding(dimensionResource(R.dimen.padding_small))
    )
}

@Composable
private fun MainImage(
    amphibian: Amphibian,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(MaterialTheme.shapes.medium),
        contentScale = ContentScale.Crop,
        painter = painterResource(R.drawable.ic_launcher_foreground),
        contentDescription = "A photo of ${amphibian.name}"
    )
}

@Composable
private fun ContentDescription(
    amphibian: Amphibian,
    modifier: Modifier = Modifier
) {
    Text(
        amphibian.description,
        modifier = modifier
            .padding(dimensionResource(R.dimen.padding_small))
    )
}

@Composable
@Preview
private fun AmphibianPreview() {
    AmphibiansTheme(darkTheme = false) {
        AmphibiansApp()
    }
}
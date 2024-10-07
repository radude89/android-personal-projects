package com.rdan.amphibians.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.rdan.amphibians.R
import com.rdan.amphibians.network.Amphibian
import com.rdan.amphibians.ui.AmphibiansApp
import com.rdan.amphibians.ui.theme.AmphibiansTheme

@Composable
fun AmphibianListScreen(
    uiState: AmphibiansUiState,
    retryAction: () -> Unit,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    when (uiState) {
        is AmphibiansUiState.Loading -> LoadingScreen(modifier.fillMaxSize())
        is AmphibiansUiState.Success -> ColumnView(
            uiState.amphibians,
            contentPadding
        )
        is AmphibiansUiState.Error -> ErrorScreen(
            retryAction,
            modifier.fillMaxSize()
        )
    }
}

@Composable
private fun ColumnView(
    amphibians: List<Amphibian>,
    contentPadding: PaddingValues
) {
    LazyColumn(contentPadding = contentPadding) {
        items(amphibians) {
            AmphibianCard(
                amphibian = it,
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.padding_small))
            )
        }
    }
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
            MainAsyncImage(amphibian, modifier)
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
private fun MainAsyncImage(
    amphibian: Amphibian,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(amphibian.imgSrc)
            .crossfade(true)
            .build(),
        contentDescription = "A photo of ${amphibian.name}",
        contentScale = ContentScale.Crop,
        error = painterResource(R.drawable.ic_broken_image),
        placeholder = painterResource(R.drawable.loading_img),
        modifier = modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium)
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
private fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.loading_img),
        contentDescription = stringResource(R.string.loading)
    )
}

@Composable
private fun ErrorScreen(
    retryAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.ic_connection_error),
            contentDescription = ""
        )
        Text(
            text = stringResource(id = R.string.loading_failed),
            modifier = Modifier.padding(16.dp)
        )
        Button(retryAction) {
            Text(stringResource(R.string.retry))
        }
    }
}

@Composable
@Preview
private fun AmphibianPreview() {
    AmphibiansTheme(darkTheme = false) {
        AmphibiansApp()
    }
}
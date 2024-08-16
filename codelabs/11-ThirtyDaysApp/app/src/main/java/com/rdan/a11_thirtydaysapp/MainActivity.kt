package com.rdan.a11_thirtydaysapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rdan.a11_thirtydaysapp.data.Motto
import com.rdan.a11_thirtydaysapp.data.mottos
import com.rdan.a11_thirtydaysapp.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    MottoApp()
                }
            }
        }
    }
}

@Composable
private fun MottoApp() {
    Scaffold(
        topBar = { MottoTopBar() }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(mottos) {
                MottoItem(
                    motto = it,
                    modifier = Modifier.padding(
                        dimensionResource(R.dimen.padding_small)
                    )
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MottoTopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayLarge
            )
        }
    )
}

@Composable
private fun MottoItem(
    motto: Motto,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = modifier
            .padding(dimensionResource(R.dimen.padding_small)),
        shape = MaterialTheme.shapes.small,
        elevation = CardDefaults.cardElevation(
            dimensionResource(R.dimen.card_elevation)
        ),
        onClick = { expanded = !expanded }
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioLowBouncy,
                        stiffness = Spring.StiffnessMediumLow
                    )
                )
        ) {
            MottoTitle(motto, modifier)
            MottoImage(motto, modifier)
            if (expanded) {
                MottoDescription(motto, modifier)
            }
        }
    }
}

@Composable
private fun MottoTitle(
    motto: Motto,
    modifier: Modifier = Modifier
) {
    Text(
        stringResource(motto.title),
        style = MaterialTheme.typography.titleLarge,
        modifier = modifier
            .padding(dimensionResource(R.dimen.padding_small))
    )
}

@Composable
private fun MottoDescription(
    motto: Motto,
    modifier: Modifier = Modifier
) {
    Text(
        stringResource(motto.motto),
        style = MaterialTheme.typography.labelMedium,
        modifier = modifier
            .padding(dimensionResource(R.dimen.padding_small))
    )
}

@Composable
private fun MottoImage(
    motto: Motto,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(MaterialTheme.shapes.medium)
            .padding(bottom = dimensionResource(R.dimen.padding_small)),
        contentScale = ContentScale.Crop,
        painter = painterResource(motto.imageResourceId),
        contentDescription = stringResource(motto.title)
    )
}

@Preview
@Composable
private fun MottoPreview() {
    AppTheme(darkTheme = false) {
        MottoApp()
    }
}

@Preview
@Composable
private fun MottoDarkThemePreview() {
    AppTheme(darkTheme = true) {
        MottoApp()
    }
}
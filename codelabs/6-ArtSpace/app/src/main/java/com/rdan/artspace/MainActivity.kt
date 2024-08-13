package com.rdan.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rdan.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceLayout()
                }
            }
        }
    }
}

@Composable
private fun ArtSpaceLayout() {
    var result by remember { mutableIntStateOf(1) }
    val imageResource = when (result) {
        0 -> R.drawable.dog1
        1 -> R.drawable.dog2
        else -> R.drawable.dog3
    }
    val title = when (result) {
        0 -> "A beautiful brown dog"
        1 -> "Corbie in action"
        else -> "Dog jumping"
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Card(
                elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
                colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.white)),
                shape = RectangleShape,
            ) {
                Image(
                    painter = painterResource(imageResource),
                    contentDescription = stringResource(R.string.gallery_description),
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .padding(16.dp)
                )
            }
            ArtworkDescriptor(
                title = title,
                artist = stringResource(R.string.stock_image_of_a_dog),
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 16.dp)
            )
        }
        val maxValue = 2
        DisplayController(
            onTapPrevious = {
                result--
                if (result == -1) {
                    result = maxValue
                }
            },
            onTapNext = {
                result++
                if (result == maxValue + 1) {
                    result = 0
                }
            },
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 32.dp)
        )
    }
}

@Composable
private fun ArtworkDescriptor(
    title: String,
    artist: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = artist,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
private fun DisplayController(
    onTapPrevious: () -> Unit,
    onTapNext: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Button(onTapPrevious) {
            Text(text = stringResource(R.string.previous))
        }
        Spacer(modifier = Modifier.width(32.dp))
        Button(onTapNext) {
            Text(text = stringResource(R.string.next))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceLayout()
    }
}
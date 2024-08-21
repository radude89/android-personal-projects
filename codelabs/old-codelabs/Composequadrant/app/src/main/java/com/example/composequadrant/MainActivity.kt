package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GridView()
                }
            }
        }
    }
}

@Composable
fun GridView() {
    Column(Modifier.fillMaxWidth()) {
        RowContentView(
            firstCardTitle = stringResource(id = R.string.card1_title),
            firstCardDescription = stringResource(id = R.string.card1_description),
            firstCardColor = Color(0xFFEADDFF),
            secondCardTitle = stringResource(id = R.string.card2_title),
            secondCardDescription = stringResource(id = R.string.card2_description),
            secondCardColor = Color(0xFFD0BCFF),
            modifier = Modifier.weight(1f)
        )
        RowContentView(
            firstCardTitle = stringResource(id = R.string.card3_title),
            firstCardDescription = stringResource(id = R.string.card3_description),
            firstCardColor = Color(0xFFB69DF8),
            secondCardTitle = stringResource(id = R.string.card4_title),
            secondCardDescription = stringResource(id = R.string.card4_description),
            secondCardColor = Color(0xFFF6EDFF),
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun RowContentView(
    firstCardTitle: String,
    firstCardDescription: String,
    firstCardColor: Color,
    secondCardTitle: String,
    secondCardDescription: String,
    secondCardColor: Color,
    modifier: Modifier = Modifier
) {
    Row(modifier) {
        Card(
            title = firstCardTitle,
            message = firstCardDescription,
            color = firstCardColor,
            modifier = modifier
        )
        Card(
            title = secondCardTitle,
            message = secondCardDescription,
            color = secondCardColor,
            modifier = modifier
        )
    }
}

@Composable
private fun Card(
    title: String,
    message: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        Text(
            text = message,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    ComposeQuadrantTheme {
        GridView()
    }
}
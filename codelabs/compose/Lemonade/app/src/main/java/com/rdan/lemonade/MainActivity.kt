package com.rdan.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rdan.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    LemonadeImageAndText(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun LemonadeImageAndText(
    modifier: Modifier = Modifier
) {
    var result by remember { mutableIntStateOf(0) }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(imageID(result)),
            contentDescription = stringResource(imageDescriptionID(result)),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .clip(RoundedCornerShape(50.dp))
                .background(Color(0xFFabcfb8))
                .padding(32.dp)
                .clickable {
                    result = updateResult(result)
                }
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            stringResource(textID(result)),
            color = Color.Black
        )
    }
}

private fun updateResult(result: Int): Int {
    var updatedResult = result
    updatedResult += 1
    if (updatedResult == 4) {
        updatedResult = 0
    }
    return updatedResult
}

private fun imageID(result: Int): Int {
    return when (result) {
        0 -> R.drawable.lemon_tree
        1 -> R.drawable.lemon_squeeze
        2 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
}

private fun imageDescriptionID(result: Int): Int {
    return when (result) {
        0 -> R.string.lemon_tree_description
        1 -> R.string.lemon_description
        2 -> R.string.glass_description
        else -> R.string.empty_glass_description
    }
}

private fun textID(result: Int): Int {
    return when (result) {
        0 -> R.string.select_lemon
        1 -> R.string.squeeze_lemon
        2 -> R.string.drink_lemonade
        else -> R.string.empty_glass
    }
}
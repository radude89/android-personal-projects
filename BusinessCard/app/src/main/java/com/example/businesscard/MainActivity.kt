package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Build
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ContentView()
                }
            }
        }
    }
}

@Composable
fun ContentView(modifier: Modifier = Modifier) {
    NameView(
        name = "Radu Dan",
        title = "Mobile Engineer"
    )
    ContactDetailsView(
        phone = "+40 727801176",
        email = "radu.ionut.dan@gmail.com",
        github = "radude89"
    )
}

@Composable
fun NameView(
    name: String,
    title: String,
    modifier: Modifier = Modifier
) {
    val image = painterResource(id = R.drawable.android_logo)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Image(
            painter = image, 
            contentDescription = stringResource(id = R.string.logo_content_description),
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .background(Color.Gray)
                .size(200.dp, 200.dp)
        )
        Text(
            text = name,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 8.dp, start = 8.dp, end = 8.dp)
        )
        Text(
            text = title,
            fontSize = 16.sp,
            color = Color(0xFF013220)
        )
    }
}

@Composable
fun ContactDetailsView(
    phone: String,
    email: String,
    github: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 32.dp)
    ) {
        ContactDetailsRowView(
            phone,
            Icons.Rounded.Phone
        )
        ContactDetailsRowView(
            email,
            Icons.Rounded.Email
        )
        ContactDetailsRowView(
            github,
            Icons.Rounded.Build
        )
    }
}

@Composable
fun ContactDetailsRowView(
    text: String,
    icon: ImageVector,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 82.dp)
    ) {
        Icon(
            icon,
            contentDescription = stringResource(R.string.contact_details_content_description),
            modifier = Modifier
                .padding(end = 8.dp)
        )
        Text(
            text = text
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    BusinessCardTheme {
        ContentView()
    }
}
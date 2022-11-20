package com.example.businesscard

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
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
                    MainView()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun CardLogo () {
    val image = painterResource(R.drawable.android_logo)
    Image(painter = image, contentDescription = "Logo", Modifier.size(100.dp))
}

@Composable
fun NameAndSurname (nameAndSurname: String) {
    Text(
        text = nameAndSurname,
        fontSize = 36.sp,
        color = Color.White
    )
}

@Composable
fun YourTitle (title: String) {
    Text(
        text = title,
        fontSize = 16.sp,
        color = Color(0xFF3ddc84),
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun TitleView() {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CardLogo()
        NameAndSurname(nameAndSurname = stringResource(R.string.Name))
        YourTitle(title = stringResource(R.string.Title))
    }
}

@Composable
fun ContactInfo () {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth().padding(0.dp, 0.dp, 0.dp, 20.dp)
    ) {
        ContactLine(icon = Icons.Rounded.Phone, description = "Phone", text = stringResource(R.string.Phone))
        ContactLine(icon = Icons.Rounded.Email, description = "E-Mail", text = stringResource(R.string.EMail))
        ContactLine(icon = Icons.Rounded.Share, description = "Nickname", text = stringResource(R.string.Nickname))
    }
}

@Composable
fun ContactLine (icon: ImageVector, description: String, text: String) {
    Column (modifier = Modifier.fillMaxWidth().height(50.dp), verticalArrangement = Arrangement.Center){
        Row (horizontalArrangement = Arrangement.Center,modifier = Modifier.padding(0.dp, 10.dp)){
            Icon(
                icon,
                contentDescription = description,
                tint = Color(0xFF3ddc84),
                modifier = Modifier.padding(50.dp, 0.dp, 0.dp, 0.dp)
            )
            Text(
                text = text,
                fontSize = 18.sp,
                color = Color.White,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 0.dp, 50.dp, 0.dp)
            )
        }
    }
}

@Composable
fun MainView() {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1a3857))
    ) {
        TitleView()
    }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxSize()
    ) {
        ContactInfo()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        MainView()
    }
}
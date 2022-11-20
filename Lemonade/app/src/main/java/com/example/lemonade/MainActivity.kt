package com.example.lemonade

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeApp()
        }
    }
}

@Composable
fun LemonadeApp() {
    var currentStep by remember { mutableStateOf(1) }
    var squizeCount by remember { mutableStateOf(0) }


    when(currentStep) {
        1 -> {
            TextAndImage(
                description = stringResource(R.string.first_step_desc),
                image = painterResource(R.drawable.lemon_tree),
                image_desc = stringResource(R.string.lemon_tree_talkback),
                onImageCLick = {
                    currentStep = 2
                    squizeCount = (2..4).random()
                }
            )
        }
        2 -> {
            TextAndImage(
                description = stringResource(R.string.second_step_desc),
                image = painterResource(R.drawable.lemon_squeeze),
                image_desc = stringResource(R.string.lemon_talkback),
                onImageCLick = {
                    squizeCount--
                    if(squizeCount<1)
                        currentStep = 3
                }
            )
        }
        3 -> {
            TextAndImage(
                description = stringResource(R.string.third_step_desc),
                image = painterResource(R.drawable.lemon_drink),
                image_desc = stringResource(R.string.lemonade_talkback),
                onImageCLick = {
                    currentStep = 4
                }
            )
        }
        4 -> {
            TextAndImage(
                description = stringResource(R.string.fourth_step_desc),
                image = painterResource(R.drawable.lemon_restart),
                image_desc = stringResource(R.string.glass_talkback),
                onImageCLick = {
                    currentStep = 1
                }
            )
        }
    }
}

@Composable
fun TextAndImage(
    description: String,
    image: Painter,
    image_desc: String,
    onImageCLick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = description, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(16.dp))
        androidx.compose.foundation.Image(
            painter = image,
            contentDescription = image_desc,
            modifier = Modifier
                .clickable(onClick = onImageCLick)
                .border(2.dp, Color.Black, RoundedCornerShape(10.dp))
        )
    }
}

fun LogikaProgramu() {

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}
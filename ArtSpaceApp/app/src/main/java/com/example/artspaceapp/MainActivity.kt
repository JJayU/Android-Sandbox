package com.example.artspaceapp

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceApp()
        }
    }
}

@Composable
fun ArtSpaceApp(
    modifier: Modifier = Modifier.fillMaxWidth()
) {
    var currentArtID by remember { mutableStateOf(1)}

    when(currentArtID){
        1 -> ArtworkMainView(
            painter = painterResource(R.drawable.art1),
            title = stringResource(R.string.art1_title),
            author = stringResource(R.string.art1_author),
            onClickPrevious = { currentArtID = 3 },
            onClickNext = { currentArtID++ })
        2 -> ArtworkMainView(
            painter = painterResource(R.drawable.art2),
            title = stringResource(R.string.art2_title),
            author = stringResource(R.string.art2_author),
            onClickPrevious = { currentArtID-- },
            onClickNext = { currentArtID++ })
        else -> ArtworkMainView(
            painter = painterResource(R.drawable.art3),
            title = stringResource(R.string.art3_title),
            author = stringResource(R.string.art3_author),
            onClickPrevious = { currentArtID-- },
            onClickNext = { currentArtID = 1 })
    }
}

@Composable
fun ArtworkMainView(
    painter: Painter,
    title: String,
    author: String,
    onClickPrevious: () -> Unit,
    onClickNext: () -> Unit
){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(20.dp)
            .fillMaxHeight(),
    ){
        ArtworkWall(painter = painter)
        Spacer(modifier = Modifier.height(10.dp))

        Column (
            modifier = Modifier.fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ){
            ArtworkTitleAndDescription(title = title, author = author)
            Spacer(modifier = Modifier.height(30.dp))
            NavigationButtons(
                onClickPrevious = onClickPrevious,
                onClickNext = onClickNext
            )
        }

    }
}

@Composable
fun ArtworkWall(
    modifier: Modifier = Modifier,
    painter: Painter
) {
    Surface(
        modifier = Modifier.border(width = 2.dp, color = Color.Gray),
        elevation = 10.dp
    ) {
        Image(
            painter = painter,
            contentDescription = stringResource(id = R.string.art1_title),
            modifier = Modifier
                .fillMaxWidth()
                .padding(40.dp)
        )
    }
}

@Composable
fun ArtworkTitleAndDescription(
    modifier: Modifier = Modifier,
    title: String,
    author: String
){
    Surface(
        elevation = 5.dp
    ) {
        Box(
            modifier = Modifier
                .padding(20.dp)
        ){
            Column() {
                Text(
                    text = title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Light
                )
                Text(
                    text = author,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun NavigationButtons(
    modifier: Modifier = Modifier,
    onClickPrevious: () -> Unit,
    onClickNext: () -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = onClickPrevious,
            modifier = Modifier.width(150.dp)
        ) {
            Text(text = "Previous")
        }
        Button(
            onClick = onClickNext,
            modifier = Modifier.width(150.dp)
        ) {
            Text(text = "Next")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ArtSpaceApp()
}
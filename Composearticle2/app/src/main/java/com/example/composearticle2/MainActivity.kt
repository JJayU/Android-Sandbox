package com.example.composearticle2

import android.icu.text.CaseMap
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign.Companion.Justify
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle2.ui.theme.ComposeArticle2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticle2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Article()
                }
            }
        }
    }
}

@Composable
fun ArticleTitle(title: String) {
    Box {
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun ArticleHeader(headerText: String) {
    Text(
        text = headerText,
        textAlign = Justify,
        modifier = Modifier
            .padding(16.dp, 0.dp, 16.dp, 0.dp)
    )
}

@Composable
fun ArticleText(text: String) {
    Text(
        text = text,
        textAlign = Justify,
        modifier = Modifier
            .padding(16.dp)
    )
}

@Composable
fun ArticleBanner() {
    val image = painterResource(R.drawable.bg_compose_background)
    Image(painter = image, contentDescription = null)
}

@Composable
fun Article() {
    Box {
        Column {
            ArticleBanner()
            ArticleTitle(title = stringResource(R.string.title))
            ArticleHeader(headerText = stringResource(R.string.header))
            ArticleText(text = stringResource(R.string.mainText))
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    ComposeArticle2Theme {
        Article()
    }
}
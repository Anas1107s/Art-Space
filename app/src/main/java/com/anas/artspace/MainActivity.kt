package com.anas.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anas.artspace.ui.theme.ArtSpaceTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Surface(
                    color = Color(0xFFFFEBEB),
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    MainFunc()
                }
            }
        }
    }
}

@Composable
fun MainFunc(
    //onNext: () -> Unit
) {
    var images by remember { mutableIntStateOf(1) }

    val imageNo = when (images) {
        1 -> R.drawable.mona_liza
        2 -> R.drawable.the_birth_of_venus
        3 -> R.drawable.the_creation_of_adam
        4 -> R.drawable.the_last_supper
        5 -> R.drawable.the_ancient_of_days
        else -> R.drawable.mona_liza
    }

    val artName = when (images) {
        1-> R.string.image_1
        2 -> R.string.image_2
        3-> R.string.image_3
        4 -> R.string.image_4
        5 -> R.string.image_5
        else -> R.string.image_1
    }

    val artistName = when (images) {
        1-> R.string.image_1_artist
        2 -> R.string.image_2_artist
        3-> R.string.image_3_artist
        4 -> R.string.image_4_artist
        5 -> R.string.image_5_artist
        else -> R.string.image_1_artist
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(vertical = 100.dp)
    ) {
        Surface(
            shadowElevation = 10.dp
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .height(420.dp)
                    .width(310.dp)
                    .background(Color(color = 0xFFFFEBEB))

            ) {
                Image(
                    painter = painterResource(imageNo),
                    contentDescription = null,
                    modifier = Modifier
                        .height(390.dp)
                        .width(280.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(100.dp))
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(Color(0xFFEC8484))
        ) {
            Text(
                text = stringResource(artName),
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                modifier = Modifier
                    .padding(10.dp)
            )
            Text(
                text = stringResource(artistName),
                modifier = Modifier
                    .padding(10.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 10.dp, start = 10.dp, end = 10.dp, top = 30.dp)
        ) {
            Button(
                onClick = { images = prevImg(images) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(color = 0xFFFF80AB),
                    contentColor = Color(color = 0xFF940041)
                ),
                modifier = Modifier
            ) {
                Text(
                    text = "Previous",
                    fontSize = 25.sp
                )

            }
            Spacer(modifier = Modifier.height(30.dp))
            Button(
                onClick = { images = nextImg(images) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(color = 0xFFFF80AB),
                    contentColor = Color(color = 0xFF940041)
                ),
                modifier = Modifier
            ) {
                Text(
                    text = "Next",
                    fontSize = 25.sp
                )
            }
        }
    }
}

fun prevImg(imageNum: Int): Int {
    var num = imageNum
    if (imageNum == 1) {
        num = 5
        return num
    } else {
        num -= 1
        return num
    }
}

fun nextImg(imageNum: Int): Int {
    var num = imageNum
    if (imageNum == 5) {
        num = 1
        return num
    } else {
        num += 1
        return num
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        MainFunc()
    }
}
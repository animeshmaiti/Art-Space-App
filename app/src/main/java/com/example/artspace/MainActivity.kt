package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
            }
        }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    var currentImage by remember { mutableIntStateOf(1) }
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            when (currentImage) {
                1 -> {
                    ArtImage(imageResource = R.drawable.plant_8825881_1280)
                    ArtDesc(title = R.string.plant, artist = R.string.artist_plant)
                    ArtActionButtons(
                        onNextButtonClick = { currentImage = 2 },
                        onPrevButtonClick = { currentImage = 4 }
                    )
                }
                2 -> {
                    ArtImage(imageResource = R.drawable.forest_8765686_1280)
                    ArtDesc(title = R.string.forest, artist = R.string.artist_forest)
                    ArtActionButtons(
                        onNextButtonClick = { currentImage = 3 },
                        onPrevButtonClick = { currentImage = 1 }
                    )
                }
                3 -> {
                    ArtImage(imageResource = R.drawable.island_8465139_1280)
                    ArtDesc(title = R.string.island, artist = R.string.artist_island)
                    ArtActionButtons(
                        onNextButtonClick = { currentImage = 4 },
                        onPrevButtonClick = { currentImage = 2 }
                    )
                }
                else -> {
                    ArtImage(imageResource = R.drawable.nature_8692760_1280)
                    ArtDesc(title = R.string.nature, artist = R.string.artist_nature)
                    ArtActionButtons(
                        onNextButtonClick = { currentImage = 1 },
                        onPrevButtonClick = { currentImage = 3 }
                    )
                }
            }
        }
    }
}

@Composable
fun ArtImage(
    imageResource: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        tonalElevation = 5.dp,
        modifier = modifier.shadow(8.dp, shape = RoundedCornerShape(8.dp))
    ) {
        Image(
            painter = painterResource(imageResource),
            modifier = Modifier.padding(32.dp),
            contentDescription = null
        )
    }
}

@Composable
fun ArtDesc(
    title: Int,
    artist: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        tonalElevation = 5.dp,
        modifier = modifier
            .padding(vertical = 30.dp)
            .fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = modifier.padding(12.dp)
        ) {
            Text(
                text = stringResource(title),
                fontSize = 22.sp,
                fontFamily = FontFamily.Serif
            )
            Text(
                text = stringResource(artist),
                fontSize = 19.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
fun ArtActionButtons(
    onNextButtonClick: () -> Unit,
    onPrevButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Button(
                onClick = { onPrevButtonClick() },
                modifier = modifier
                    .padding(8.dp)
                    .weight(1f)
            ) {
                Text(text = "Previous")
            }
            Button(
                onClick = { onNextButtonClick() },
                modifier
                    .padding(8.dp)
                    .weight(1f)
            ) {
                Text(text = "Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}
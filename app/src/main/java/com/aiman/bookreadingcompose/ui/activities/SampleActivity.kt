package com.aiman.bookreadingcompose.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aiman.bookreadingcompose.R
import com.aiman.bookreadingcompose.theme.CustomFont.robotoCondenseFamily

class SampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Column(modifier =
            Modifier
                .padding(16.dp)
                .fillMaxHeight()
                .fillMaxWidth(),
            ) {

                Header()
                HelloTitle()
                Spacer(modifier = Modifier
                    .height(8.dp)
                    .fillMaxWidth())
                CurrentlyReading()

            }
        }
    }

    @Composable
    fun Header() {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween) {
            Image(
                painter = painterResource(id = R.drawable.user_placeholder),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .border(3.dp, Color.White)
            )

            Image(
                painter = painterResource(id = R.drawable.ic_book_shelf),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp),
                colorFilter = ColorFilter.tint(color = Color.White),
                alignment = Alignment.Center
            )

        }

    }

    @Composable
    fun HelloTitle() {
        Text(
            "Hey, Aiman!",
            color = Color.White,
            fontSize = 32.sp,
            fontFamily = robotoCondenseFamily,
            fontWeight = FontWeight.Normal
        )
    }

    @Preview
    @Composable
    fun PreviewHeader() {
        Header()
    }

    @Composable
    fun CurrentlyReading() {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        colorResource(id = R.color.gradient_purple),
                        colorResource(id = R.color.gradient_purple_mid),
                        colorResource(id = R.color.gradient_pink)
                    )
                ),
                shape = RoundedCornerShape(8.dp)
            )
        ) {

            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    "Currently Reading",
                    color = colorResource(id = R.color.text_color_pink),
                    fontSize = 18.sp,
                    fontFamily = robotoCondenseFamily
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    "No Place Like Here",
                    color = Color.White,
                    fontSize = 26.sp,
                    fontFamily = robotoCondenseFamily,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    "Christina June",
                    color = colorResource(id = R.color.text_color_pink),
                    fontSize = 22.sp,
                    fontFamily = robotoCondenseFamily,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    "16 Chapters left      22.4%",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontFamily = robotoCondenseFamily,
                    fontWeight = FontWeight.Bold
                )

                LinearProgressIndicator(
                    progress = 22.4f,
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.White
                )
            }
        }
    }
}
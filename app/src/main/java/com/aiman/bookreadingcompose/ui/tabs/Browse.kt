package com.aiman.bookreadingcompose.ui.tabs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aiman.bookreadingcompose.R
import com.aiman.bookreadingcompose.models.BookGenre
import com.aiman.bookreadingcompose.theme.CustomFont.robotoCondenseFamily
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import com.aiman.bookreadingcompose.data.BooksRepository

object Browse {
    @Composable
    fun BrowseTab() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(colorResource(id = R.color.background_dark))
        ) {
            Column(
                modifier = Modifier.padding(
                    top = 8.dp,
                    bottom = 8.dp,
                    start = 12.dp,
                    end = 12.dp
                ),
            ) {
                Toolbar()
                Spacer(modifier = Modifier.height(12.dp))
                BookGenreGrid(bookGenreList = BooksRepository.getGenres())
            }
        }
    }

    @Composable
    fun Toolbar() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 6.dp),
        ) {

            var searchValue by remember { mutableStateOf("Search books, authors or genres") }
            TextField(
                value = searchValue,
                onValueChange = { searchValue = it },
                textStyle = TextStyle(
                    color = Color.White,
                    fontFamily = robotoCondenseFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(
                        color = colorResource(id = R.color.background_light),
                        shape = CircleShape
                    ),
                leadingIcon = { Icon(painter = painterResource(id = R.drawable.ic_search), null, tint = Color.White) },
                trailingIcon = { Icon(painter = painterResource(id = R.drawable.ic_filter), null, tint = Color.White,modifier = Modifier.size(22.dp)) }
            )

        }

    }


    @Composable
    fun BookGenreGrid(bookGenreList: ArrayList<BookGenre>) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
        ) {
            items(bookGenreList.windowed(2, 2, true)) { subList ->
                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    subList.forEach { genre ->
                        BookGenreItem(genre)
                    }
                }
                Spacer(modifier = Modifier.height(20.dp).fillMaxWidth())
            }

            // Avoid over-lapping with bottom navigation bar
            item {
                Spacer(modifier = Modifier.height(50.dp))
            }
        }
    }

    @Composable
    fun BookGenreItem(genre: BookGenre) {
        Box(modifier = Modifier
            .height(230.dp)
            .width(165.dp)
            .background(
                color = genre.backgroundColor,
                shape = RoundedCornerShape(8.dp)
            ),

        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    genre.name,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = robotoCondenseFamily,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                )

                Image(
                    painter = painterResource(id = genre.bookImage),
                    null,
                    modifier = Modifier
                        .height(160.dp)
                        .fillMaxWidth(0.60f),
                    contentScale = ContentScale.Inside
                )
            }

        }
    }

}
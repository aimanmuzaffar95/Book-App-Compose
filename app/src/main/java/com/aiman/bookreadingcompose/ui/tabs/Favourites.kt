package com.aiman.bookreadingcompose.ui.tabs

import android.content.Context
import android.widget.Space
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.aiman.bookreadingcompose.R
import com.aiman.bookreadingcompose.data.BooksRepository
import androidx.compose.foundation.lazy.items
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.aiman.bookreadingcompose.models.Book
import com.aiman.bookreadingcompose.theme.robotoCondenseFamily

@Composable
fun FavouritesTab(context: Context) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(colorResource(id = R.color.background_dark))
    ) {
        LazyColumn(
            modifier = Modifier.padding(
                vertical = 8.dp,
                horizontal = 12.dp)
        ) {
            items(BooksRepository.favourites) { book ->
                FavouriteItem(context = context, book = book)
            }

            // Avoid over-lapping with bottom navigation bar
            item {
                Spacer(modifier = Modifier.height(50.dp))
            }
        }
    }
}

@Composable
fun FavouriteItem(context: Context, book: Book) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            openBookDetailsActivity(context, book, true)
        }
    ) {
        Image(
            painter = painterResource(id = book.bookImage),
            contentDescription = null,
            contentScale = ContentScale.Inside,
            modifier = Modifier.width(140.dp)
        )

        Column(
            modifier = Modifier.padding(start = 16.dp)
        ) {
            Text(
                book.bookName,
                color = Color.White,
                fontSize = 21.sp,
                fontFamily = robotoCondenseFamily,
                fontWeight = FontWeight.SemiBold,
                fontStyle = FontStyle.Italic,
                maxLines = 2,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                book.authorName,
                color = Color.Gray,
                fontSize = 18.sp,
                fontFamily = robotoCondenseFamily,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Italic,
                maxLines = 2,
            )
            Spacer(modifier = Modifier.height(4.dp))

        }
    }
    Spacer(modifier = Modifier.height(16.dp))
}
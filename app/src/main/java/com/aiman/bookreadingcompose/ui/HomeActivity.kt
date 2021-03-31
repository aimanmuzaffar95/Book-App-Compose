package com.aiman.bookreadingcompose.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aiman.bookreadingcompose.R
import com.aiman.bookreadingcompose.data.BooksRepository
import com.aiman.bookreadingcompose.models.MyBook
import com.aiman.bookreadingcompose.utils.CustomFont

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {

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
                        MyBooks()
                    }

                }
            }
        }
    }

    @Composable
    fun MyBooks() {

        Spacer(modifier = Modifier.height(22.dp))
        Text(
            "My Books",
            color = Color.White,
            fontSize = 28.sp,
            fontFamily = CustomFont.robotoCondenseFamily,
            fontWeight = FontWeight.SemiBold,
        )
        Spacer(modifier = Modifier.height(12.dp))
        MyBooksList(bookList = BooksRepository.getMyBooks())
    }

    @Composable
    fun Toolbar() {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(id = R.drawable.ic_menu),
                contentDescription = null,
                tint = Color.White
            )

            Spacer(modifier = Modifier.width(8.dp))

            var searchValue by remember { mutableStateOf("") }
            TextField(
                value = searchValue,
                onValueChange = { searchValue = it },
                modifier = Modifier.width(230.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    backgroundColor = colorResource(id = R.color.search_bar_background)
                ),
            )

            Spacer(modifier = Modifier.width(8.dp))

            Icon(
                painter = painterResource(id = R.drawable.ic_scan),
                contentDescription = null,
                tint = Color.White
            )

            Spacer(modifier = Modifier.width(8.dp))

            Icon(
                painter = painterResource(id = R.drawable.ic_notification_bell),
                contentDescription = null,
                tint = Color.White
            )
        }

    }

    @Composable
    fun MyBooksList(bookList: ArrayList<MyBook>) {
        LazyRow {
            items(bookList) { book ->
                MyBookColumn(book = book)
            }
        }
    }


    @Composable
    fun MyBookColumn(book: MyBook) {
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .width(140.dp)) {
            Image(
                painter = painterResource(id = book.bookImage),
                null,
                modifier = Modifier
                    .height(200.dp)
                    .width(140.dp),
                contentScale = ContentScale.FillHeight
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                book.bookName,
                color = Color.White,
                fontSize = 18.sp,
                fontFamily = CustomFont.robotoCondenseFamily,
                fontWeight = FontWeight.SemiBold,
                fontStyle = FontStyle.Italic,
                maxLines = 2,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                book.authorName,
                color = Color.Gray,
                fontSize = 16.sp,
                fontFamily = CustomFont.robotoCondenseFamily,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Italic,
                maxLines = 2,
            )
        }
    }

}
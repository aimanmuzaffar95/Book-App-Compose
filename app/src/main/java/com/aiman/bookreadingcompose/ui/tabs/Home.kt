package com.aiman.bookreadingcompose.ui.tabs

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aiman.bookreadingcompose.R
import com.aiman.bookreadingcompose.data.BooksRepository
import com.aiman.bookreadingcompose.models.Book
import com.aiman.bookreadingcompose.theme.robotoCondenseFamily
import com.aiman.bookreadingcompose.ui.activities.BookDetailActivity

const val key_book = "key_book"

@Composable
fun HomeTab(context: Context) {

    val bestSellerBooks = remember { BooksRepository.getBestSellers() }

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(colorResource(id = R.color.background_dark)),
    ) {

        item {
            Toolbar()
        }

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
            ) {
                MyBooks(context)
            }
        }

        item {
            Text(
                context.getString(R.string.best_sellers),
                color = Color.White,
                fontSize = 28.sp,
                fontFamily = robotoCondenseFamily,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 8.dp),
            )
            Spacer(modifier = Modifier.height(12.dp))
        }

        items(bestSellerBooks.windowed(2, 2, true)) { subList ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                subList.forEach { book ->
                    BestSellerItem(book = book, context = context)
                }
            }
        }

        // Avoid over-lapping with bottom navigation bar
        item {
            Spacer(modifier = Modifier.height(50.dp))
        }

    }
}

@Composable
fun MyBooks(context: Context) {

    Spacer(modifier = Modifier.height(22.dp))
    Text(
        context.getString(R.string.my_books),
        color = Color.White,
        fontSize = 28.sp,
        fontFamily = robotoCondenseFamily,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(start = 4.dp),
    )
    Spacer(modifier = Modifier.height(12.dp))
    MyBooksList(bookList = BooksRepository.getMyBooks(), context)
}

@Composable
fun Toolbar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 6.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            painter = painterResource(id = R.drawable.ic_menu),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(25.dp)
                .clickable {}
        )

        Spacer(modifier = Modifier.width(8.dp))

        var searchValue by remember { mutableStateOf("") }
        TextField(
            value = searchValue,
            onValueChange = { searchValue = it },
            modifier = Modifier
                .width(230.dp)
                .height(45.dp)
                .background(
                    color = colorResource(id = R.color.background_light),
                    shape = CircleShape
                ),
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    null,
                    tint = Color.White
                )
            }
        )

        Spacer(modifier = Modifier.width(8.dp))

        Icon(
            painter = painterResource(id = R.drawable.ic_scan),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .width(25.dp)
                .height(25.dp)
                .clickable {}
        )

        Spacer(modifier = Modifier.width(8.dp))

        Icon(
            painter = painterResource(id = R.drawable.ic_notification_bell),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(44.dp)
                .padding(vertical = 8.dp, horizontal = 6.dp)
                .clickable {}
        )
    }

}

@Composable
fun MyBooksList(bookList: ArrayList<Book>, context: Context) {
    LazyRow {
        items(bookList) { book ->
            MyBookItem(book = book, context = context)
        }
    }
}

@Composable
fun MyBookItem(book: Book, context: Context) {
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .width(140.dp)
            .padding(8.dp)
            .clickable { openBookDetailsActivity(context, book) }
    ) {
        Image(
            painter = painterResource(id = book.bookImage),
            null,
            modifier = Modifier
                .height(180.dp)
                .width(140.dp),
            contentScale = ContentScale.FillHeight
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            book.bookName,
            color = Color.White,
            fontSize = 18.sp,
            fontFamily = robotoCondenseFamily,
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Italic,
            maxLines = 2,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            book.authorName,
            color = Color.Gray,
            fontSize = 16.sp,
            fontFamily = robotoCondenseFamily,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Italic,
            maxLines = 2,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            LinearProgressIndicator(
                progress = book.bookProgress,
                modifier = Modifier.width(5.dp),
                color = colorResource(id = R.color.progress_color),
                backgroundColor = Color.White,
            )
            Text(
                "${(book.bookProgress * 5).toInt()}%",
                color = Color.White,
                fontSize = 13.sp,
                fontFamily = robotoCondenseFamily,
                fontWeight = FontWeight.Light
            )
        }

    }
}

@Composable
fun BestSellerItem(book: Book, context: Context) {
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .wrapContentHeight()
            .padding(8.dp)
            .clickable { openBookDetailsActivity(context, book) },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = book.bookImage),
            null,
            modifier = Modifier
                .height(200.dp)
                .width(170.dp),
            contentScale = ContentScale.Inside
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            book.bookName,
            color = Color.White,
            fontSize = 18.sp,
            fontFamily = robotoCondenseFamily,
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Italic,
            maxLines = 3,
            textAlign = TextAlign.Center
        )

        Text(
            book.authorName,
            color = Color.Gray,
            fontSize = 16.sp,
            fontFamily = robotoCondenseFamily,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Italic,
            maxLines = 2,
        )
    }
}

fun openBookDetailsActivity(context: Context, book: Book) {
    Intent(context, BookDetailActivity::class.java).run {
        this.putExtra(key_book, book)
        context.startActivity(this)
    }
}
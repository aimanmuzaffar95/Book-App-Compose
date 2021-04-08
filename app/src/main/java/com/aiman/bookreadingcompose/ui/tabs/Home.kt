package com.aiman.bookreadingcompose.ui.tabs

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
import com.aiman.bookreadingcompose.models.MyBook
import com.aiman.bookreadingcompose.theme.CustomFont

object Home {

    @Composable
    fun HomeTab() {

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
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)) {
                    MyBooks()
                }
            }

            item {
                Text(
                    "Best Sellers",
                    color = Color.White,
                    fontSize = 28.sp,
                    fontFamily = CustomFont.robotoCondenseFamily,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(start = 8.dp),
                )
                Spacer(modifier = Modifier.height(12.dp))
            }


//            items(bestSellerBooks) { book ->
//                Column(Modifier.fillMaxWidth()) {
//                    BestSellerItem(book = book)
//                }
//            }

            items(bestSellerBooks.windowed(2, 2, true)) { subList ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    subList.forEach { book ->
                        BestSellerItem(book = book)
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
    fun MyBooks() {

        Spacer(modifier = Modifier.height(22.dp))
        Text(
            "My Books",
            color = Color.White,
            fontSize = 28.sp,
            fontFamily = CustomFont.robotoCondenseFamily,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(start = 4.dp),
        )
        Spacer(modifier = Modifier.height(12.dp))
        MyBooksList(bookList = BooksRepository.getMyBooks())
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
                trailingIcon = { Icon(painter = painterResource(id = R.drawable.ic_search), null, tint = Color.White) }
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
    fun MyBooksList(bookList: ArrayList<MyBook>) {
        LazyRow {
            items(bookList) { book ->
                MyBookItem(book = book)
            }
        }
    }
    
    @Composable
    fun MyBookItem(book: MyBook) {
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .width(140.dp)
                .padding(8.dp)
                .clickable {} ) {
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
                    fontFamily = CustomFont.robotoCondenseFamily,
                    fontWeight = FontWeight.Light
                )
            }

        }
    }

    @Composable
    fun BestSellers() {
        Spacer(modifier = Modifier.height(22.dp))
        Text(
            "Best Sellers",
            color = Color.White,
            fontSize = 28.sp,
            fontFamily = CustomFont.robotoCondenseFamily,
            fontWeight = FontWeight.SemiBold,
        )
        Spacer(modifier = Modifier.height(12.dp))
        BestSellersGrid(books = BooksRepository.getBestSellers())
    }

    @Composable
    fun BestSellersGrid(books: ArrayList<Book>) {

    }

    @Composable
    fun BestSellerItem(book: Book) {
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentHeight()
                .padding(8.dp)
                .clickable {},
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
                    fontFamily = CustomFont.robotoCondenseFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontStyle = FontStyle.Italic,
                    maxLines = 3,
                    textAlign = TextAlign.Center
                )

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
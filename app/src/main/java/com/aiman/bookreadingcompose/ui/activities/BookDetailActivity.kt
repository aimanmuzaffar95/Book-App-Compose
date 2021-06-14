package com.aiman.bookreadingcompose.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aiman.bookreadingcompose.R
import com.aiman.bookreadingcompose.data.BooksRepository
import com.aiman.bookreadingcompose.models.Book
import com.aiman.bookreadingcompose.theme.robotoCondenseFamily
import com.aiman.bookreadingcompose.ui.tabs.key_book
import com.aiman.bookreadingcompose.ui.tabs.key_is_bookmarked
import com.aiman.bookreadingcompose.utils.getComposeColor

class BookDetailActivity : AppCompatActivity() {

    lateinit var book: Book

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        book = intent.getParcelableExtra(key_book)!!
        changeStatusBarColor(book.backgroundColor)

        setContent {
            MaterialTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    TopSection()
                    BottomSection()
                }
            }
        }
    }

    private fun changeStatusBarColor(color: String) {
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = android.graphics.Color.parseColor(color)
    }

    @Composable
    fun TopSection() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = getComposeColor(book.backgroundColor)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TopBar()
            BookDetail()
            Spacer(modifier = Modifier.height(18.dp))
        }
    }

    @Composable
    fun TopBar() {
        val iconSize = 50.dp

        val isBookmarked = remember { mutableStateOf(
            intent.getBooleanExtra(key_is_bookmarked, false)
        ) }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .size(iconSize)
                    .padding(vertical = 8.dp, horizontal = 6.dp)
                    .clickable { onBackPressed() }
            )

            Icon(
                painter =
                    if(isBookmarked.value)
                        painterResource(id = R.drawable.ic_bookmark_filled)
                    else
                        painterResource(id = R.drawable.ic_bookmark),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .size(iconSize)
                    .padding(vertical = 8.dp, horizontal = 6.dp)
                    .clickable {
                        isBookmarked.value = !isBookmarked.value
                        if(isBookmarked.value)
                            BooksRepository.favourites.add(book)
                        else
                            BooksRepository.favourites.remove(book)
                    }
            )
        }
    }

    @Composable
    fun BookDetail() {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = book.bookImage),
                contentDescription = null,
                modifier = Modifier
                    .height(280.dp)
                    .clip(RoundedCornerShape(12.dp))
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = book.bookName,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                fontFamily = robotoCondenseFamily
            )

            Text(
                text = "By ${book.authorName}",
                color = Color.White,
                fontWeight = Normal,
                fontSize = 18.sp,
                fontFamily = robotoCondenseFamily
            )

            Spacer(modifier = Modifier.height(20.dp))

            DetailGrid()
            Spacer(modifier = Modifier.height(32.dp))
            ActionButtons()

        }
    }

    @Composable
    fun DetailGrid() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(id = R.string.rating),
                    color = Color.White,
                    fontWeight = FontWeight.Light,
                    fontSize = 16.sp,
                    fontFamily = robotoCondenseFamily
                )

                Text(
                    text = "4.7",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    fontFamily = robotoCondenseFamily
                )
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(id = R.string.pages),
                    color = Color.White,
                    fontWeight = FontWeight.Light,
                    fontSize = 16.sp,
                    fontFamily = robotoCondenseFamily
                )

                Text(
                    text = "155",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    fontFamily = robotoCondenseFamily
                )
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(id = R.string.language),
                    color = Color.White,
                    fontWeight = FontWeight.Light,
                    fontSize = 16.sp,
                    fontFamily = robotoCondenseFamily
                )

                Text(
                    text = "ENG",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    fontFamily = robotoCondenseFamily
                )
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(id = R.string.audio),
                    color = Color.White,
                    fontWeight = FontWeight.Light,
                    fontSize = 16.sp,
                    fontFamily = robotoCondenseFamily
                )

                Text(
                    text = "02 Hrs",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    fontFamily = robotoCondenseFamily
                )
            }
        }
    }

    @Composable
    fun ActionButtons() {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {

            ActionButton(
                text = getString(R.string.read_book), modifier =
                Modifier.background(
                    shape = RoundedCornerShape(topStartPercent = 20, bottomStartPercent = 20),
                    color = colorResource(id = R.color.action_button_background_color)
                ),
                R.drawable.ic_read_book
            )

            Spacer(modifier = Modifier.width(4.dp))

            ActionButton(
                text = getString(R.string.listen_book), modifier =
                Modifier.background(
                    shape = RoundedCornerShape(topEndPercent = 20, bottomEndPercent = 20),
                    color = colorResource(id = R.color.action_button_background_color)
                ),
                R.drawable.ic_listen_audio
            )
        }
    }

    @Composable
    fun ActionButton(text: String, modifier: Modifier, icon: Int) {
        val buttonHeight = 50.dp
        val buttonWidth = 170.dp

        Row(
            modifier = modifier
                .height(buttonHeight)
                .width(buttonWidth)
                .clickable {},
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(2.dp))
            Text(
                text = text,
                color = Color.White
            )
        }
    }

    @Composable
    fun BottomSection() {
        val headingFontSize = 22.sp
        val contentFontSize = 18.sp

        Box(
            modifier = Modifier
                .wrapContentWidth()
                .background(color = colorResource(id = R.color.background_dark))
        ) {

            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(
                    getString(R.string.what_is_it_about),
                    color = Color.White,
                    fontSize = headingFontSize,
                    fontFamily = robotoCondenseFamily,
                    fontWeight = SemiBold,
                )
                Text(
                    stringResource(id = R.string.about_book),
                    color = Color.White,
                    fontSize = contentFontSize,
                    fontFamily = robotoCondenseFamily,
                    fontWeight = Normal,
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    getString(R.string.who_is_it_for),
                    color = Color.White,
                    fontSize = headingFontSize,
                    fontFamily = robotoCondenseFamily,
                    fontWeight = SemiBold,
                )
                Text(
                    stringResource(id = R.string.lorem_ipsum),
                    color = Color.White,
                    fontSize = contentFontSize,
                    fontFamily = robotoCondenseFamily,
                    fontWeight = Normal,
                )
            }
        }


    }
}
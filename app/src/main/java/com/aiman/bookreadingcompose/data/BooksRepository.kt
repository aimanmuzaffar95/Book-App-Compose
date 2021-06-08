package com.aiman.bookreadingcompose.data

import androidx.compose.ui.graphics.Color
import com.aiman.bookreadingcompose.R
import com.aiman.bookreadingcompose.models.Book
import com.aiman.bookreadingcompose.models.BookGenre

class BooksRepository {
    companion object {
        fun getMyBooks(): ArrayList<Book> {
            return arrayListOf(
                Book("No place like here", "Christina June", R.drawable.book_no_place_like_here, "#A66BA2", "Ashlyn Zanotti has big plans for the summer. She’s just spent a year at boarding school and can’t wait to get home. But when Ashlyn’s father is arrested for tax evasion and her mother enters a rehab facility for “exhaustion,” a.k.a. depression, her life is turned upside down.", bookProgress = 10f),
                Book("To Kill a Mockingbird", "Harper Lee", R.drawable.book_to_kill_a_mocking_bird, "#57503D", "", bookProgress = 5f),
                Book("The Book Thief", "Markus Zusak", R.drawable.book_the_book_theif, "#83631F", "", bookProgress = 16f),
            )
        }

        fun getBestSellers(): ArrayList<Book> {
            return arrayListOf(
                Book("To the moon", "Max Born", R.drawable.book_to_the_moon, "#36A0B5", ""),
                Book("Secret of the Divine Love", "A. Helwa", R.drawable.book_secrets_of_divine_love, "#f07f4a", ""),
                Book("Harry Potter ", "J.K. Rowling", R.drawable.book_harry_porter,"#55368C", ""),
                Book("In a Land of Paper Gods", "Rebecca Mackenzie", R.drawable.book_in_a_land_of_paper_gods, "#145E82", ""),
                Book("Will My Cat Eat", "Caitlin Doughty", R.drawable.book_will_my_cat_eat_my_eyeballs, "#CA3F5A", ""),
                Book("Clap When You Land", "Elizabeth Acevedo", R.drawable.book_clap_when_you_can, "#B15236", ""),
            )
        }

        fun getGenres(): ArrayList<BookGenre> {
            return arrayListOf(
                BookGenre("Biography", Color(0xFFB7143C), R.drawable.book_the_reign_of_victoria),
                BookGenre("Business", Color(0xFF0E6A500), R.drawable.book_tribe_of_mentors),
                BookGenre("Children", Color(0xFFEF4C45), R.drawable.book_boss_of_the_body),
                BookGenre("Cookery", Color(0xFFF46217), R.drawable.book_eat_better),
                BookGenre("Fiction", Color(0xFF009ADE2), R.drawable.book_lost_in_the_never_woods),
                BookGenre("Novels", Color(0xFFD36A43), R.drawable.book_how_novels_think),
            )
        }
    }

}
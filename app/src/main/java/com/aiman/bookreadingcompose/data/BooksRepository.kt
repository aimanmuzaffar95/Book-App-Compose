package com.aiman.bookreadingcompose.data

import androidx.compose.ui.graphics.Color
import com.aiman.bookreadingcompose.R
import com.aiman.bookreadingcompose.models.Book
import com.aiman.bookreadingcompose.models.BookGenre
import com.aiman.bookreadingcompose.models.MyBook

class BooksRepository {
    companion object {
        fun getMyBooks(): ArrayList<MyBook> {
            return arrayListOf(
                MyBook("No place like here", "Christina June", R.drawable.book_no_place_like_here, 10f),
                MyBook("To Kill a Mockingbird", "Harper Lee", R.drawable.book_to_kill_a_mocking_bird, 5f),
                MyBook("The Book Thief", "Markus Zusak", R.drawable.book_the_book_theif, 16f),
            )
        }

        fun getBestSellers(): ArrayList<Book> {
            return arrayListOf(
                Book("To the moon", "Max Born", R.drawable.book_to_the_moon),
                Book("Secret of the Divine Love", "A. Helwa", R.drawable.book_secrets_of_divine_love),
                Book("Harry Potter ", "J.K. Rowling", R.drawable.book_harry_porter),
                Book("In a Land of Paper Gods", "Rebecca Mackenzie", R.drawable.book_in_a_land_of_paper_gods),
                Book("Will My Cat Eat", "Caitlin Doughty", R.drawable.book_will_my_cat_eat_my_eyeballs),
                Book("Clap When You Land", "Elizabeth Acevedo", R.drawable.book_clap_when_you_can),
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
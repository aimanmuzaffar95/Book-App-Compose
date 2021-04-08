package com.aiman.bookreadingcompose.data

import com.aiman.bookreadingcompose.R
import com.aiman.bookreadingcompose.models.Book
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
    }
}
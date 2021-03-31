package com.aiman.bookreadingcompose.data

import com.aiman.bookreadingcompose.R
import com.aiman.bookreadingcompose.models.MyBook

class BooksRepository {
    companion object {
        fun getMyBooks(): ArrayList<MyBook> {
            return arrayListOf(
                MyBook("No place like here", "Christina June", R.drawable.book_no_place_like_here, 0.0f),
                MyBook("To Kill a Mockingbird", "Harper Lee", R.drawable.book_to_kill_a_mocking_bird, 0.0f),
                MyBook("The Book Thief", "Markus Zusak", R.drawable.book_the_book_theif, 0.0f),
            )
        }
    }
}
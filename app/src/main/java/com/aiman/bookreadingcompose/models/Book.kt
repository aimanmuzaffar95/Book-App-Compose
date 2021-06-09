package com.aiman.bookreadingcompose.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Book(
    val bookName: String,
    val authorName: String,
    val bookImage: Int,
    val backgroundColor: String,
    val bookProgress: Float = 0f
): Parcelable
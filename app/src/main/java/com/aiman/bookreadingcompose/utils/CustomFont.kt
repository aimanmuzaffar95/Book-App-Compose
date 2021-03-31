package com.aiman.bookreadingcompose.utils

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.aiman.bookreadingcompose.R

object CustomFont {

    val robotoCondenseFamily = FontFamily(
        Font(R.font.roboto_condensed_regular, FontWeight.Normal),
        Font(R.font.roboto_condensed_bold, FontWeight.Bold),
        Font(R.font.roboto_condensed_light, FontWeight.Light),
        Font(R.font.roboto_medium, FontWeight.SemiBold),
    )

    val montSerratFamily = FontFamily(
        Font(R.font.montserrat_black, FontWeight.Normal),
        Font(R.font.montserrat_bold, FontWeight.Bold),
    )
}
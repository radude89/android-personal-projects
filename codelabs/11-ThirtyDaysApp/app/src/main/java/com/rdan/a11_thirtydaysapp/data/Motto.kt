package com.rdan.a11_thirtydaysapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.rdan.a11_thirtydaysapp.R

data class Motto(
    @DrawableRes val imageResourceId: Int,
    @StringRes val title: Int,
    @StringRes val motto: Int,
)

val mottos = listOf(
    Motto(R.drawable.motto_1, R.string.day_1_title, R.string.day_1_description),
    Motto(R.drawable.motto_2, R.string.day_2_title, R.string.day_2_description),
    Motto(R.drawable.motto_3, R.string.day_3_title, R.string.day_3_description),
    Motto(R.drawable.motto_4, R.string.day_4_title, R.string.day_4_description),
    Motto(R.drawable.motto_5, R.string.day_5_title, R.string.day_5_description),
    Motto(R.drawable.motto_6, R.string.day_6_title, R.string.day_6_description)
)
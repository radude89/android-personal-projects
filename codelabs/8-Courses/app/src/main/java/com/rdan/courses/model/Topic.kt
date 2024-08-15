package com.rdan.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val text: Int,
    val seats: Int,
    @DrawableRes val image: Int
)

package com.rdan.a11_thirtydaysapp.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(10.dp),
    medium = RoundedCornerShape(
        topStart = 50.dp,
        bottomStart = 25.dp,
        topEnd = 0.dp,
        bottomEnd = 15.dp
    ),
)

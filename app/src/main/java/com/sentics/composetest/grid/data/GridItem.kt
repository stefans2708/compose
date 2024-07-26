package com.sentics.composetest.grid.data

import androidx.annotation.DrawableRes

data class GridItem(
    val id: String,
    val title: String,
    @DrawableRes val image: Int
)

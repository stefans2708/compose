package com.sentics.composetest.grid.data

import androidx.annotation.DrawableRes

sealed class GridItem(val span:Int) {

    data class SmallItem(
        val id: String,
        val title: String,
        @DrawableRes val image: Int
    ) : GridItem(1)

    data class LargeItem(
        val id: String,
        val title: String,
        @DrawableRes val image: Int
    ) : GridItem(2)

    data class HeaderItem(val title: String) : GridItem(2)

    data object AddItem : GridItem(1)
}

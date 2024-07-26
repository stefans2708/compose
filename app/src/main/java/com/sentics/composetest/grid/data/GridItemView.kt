package com.sentics.composetest.grid.data

import androidx.annotation.DrawableRes

sealed class GridItemView(
    val span: Int,
    val id: String,
    val title: String,
    @DrawableRes val image: Int,
    val sectionId: Int
) {

    class SmallItem(
        id: String,
        title: String,
        sectionId: Int,
        image: Int
    ) : GridItemView(span = 1, id = id, title = title, sectionId = sectionId, image = image)

    class LargeItem(
        id: String,
        title: String,
        sectionId: Int,
        image: Int
    ) : GridItemView(span = 2, id = id, title = title, sectionId = sectionId, image = image)

    class HeaderItem(
        title: String,
        sectionId: Int,
    ) : GridItemView(span = 2, id = "", title = title, image = 0, sectionId = sectionId)

    class AddItem(
        sectionId: Int,
    ) : GridItemView(span = 1, id = "", title = "", image = 0, sectionId = sectionId)
}

fun GridItem.toSmallGridItem(sectionId: Int) =
    GridItemView.SmallItem(
        id = id,
        title = title,
        image = image,
        sectionId = sectionId
    )

fun GridItem.toLargeGridItem(sectionId: Int) =
    GridItemView.LargeItem(
        id = id,
        title = title,
        image = image,
        sectionId = sectionId
    )

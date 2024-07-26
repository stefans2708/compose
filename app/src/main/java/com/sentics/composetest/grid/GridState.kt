package com.sentics.composetest.grid

import com.sentics.composetest.grid.data.GridItemView

data class GridState(
    val items: List<GridItemView> = listOf(),
    val showUpdateDialog: Boolean = false,
    val itemToUpdate: GridItemView? = null,
    val sectionToUpdate: Int? = null,
    val toastMessage: String? = null
)

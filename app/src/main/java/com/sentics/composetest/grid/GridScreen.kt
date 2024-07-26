package com.sentics.composetest.grid

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sentics.composetest.grid.component.ItemAdd
import com.sentics.composetest.grid.component.ItemHeader
import com.sentics.composetest.grid.component.ItemLarge
import com.sentics.composetest.grid.component.ItemSmall
import com.sentics.composetest.grid.data.GridData
import com.sentics.composetest.grid.data.GridItem
import com.sentics.composetest.ui.theme.ComposeTestTheme

@Composable
fun GridScreen(modifier: Modifier = Modifier) {
    val vm: GridViewModel = viewModel()
    val sections by vm.gridItems.collectAsStateWithLifecycle()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
    ) {
        for (section in sections) {
            for (item in section.items) {
                item(span = { GridItemSpan(item.span) }) {
                    when (item) {
                        is GridItem.HeaderItem -> ItemHeader(data = item)
                        is GridItem.LargeItem -> ItemLarge(data = item)
                        is GridItem.SmallItem -> ItemSmall(data = item)
                        is GridItem.AddItem -> ItemAdd(onAddClick = { /*TODO*/ })
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun GridScreenPreview() {
    ComposeTestTheme {
        GridScreen()
    }
}
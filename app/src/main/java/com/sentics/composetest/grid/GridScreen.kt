package com.sentics.composetest.grid

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sentics.composetest.grid.component.AddItemBottomDialog
import com.sentics.composetest.grid.component.ItemAdd
import com.sentics.composetest.grid.component.ItemHeader
import com.sentics.composetest.grid.component.ItemLarge
import com.sentics.composetest.grid.component.ItemSmall
import com.sentics.composetest.grid.data.GridItemView
import com.sentics.composetest.ui.theme.ComposeTestTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GridScreen(modifier: Modifier = Modifier) {
    val vm: GridViewModel = viewModel()
    val data by vm.state.collectAsStateWithLifecycle()
    val context = LocalContext.current

    Scaffold {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = modifier.padding(it)
        ) {
            for (item in data.items) {
                item(span = { GridItemSpan(item.span) }) {
                    when (item) {
                        is GridItemView.HeaderItem -> ItemHeader(data = item)

                        is GridItemView.LargeItem ->
                            ItemLarge(
                                data = item,
                                onEditItemClick = { vm.onEditItemsClick(item) }
                            )

                        is GridItemView.SmallItem ->
                            ItemSmall(
                                data = item,
                                onEditItemClick = { vm.onEditItemsClick(item) }
                            )

                        is GridItemView.AddItem -> ItemAdd(onAddClick = { vm.onAddItemClick(item) })
                    }
                }
            }
        }
        if (data.showUpdateDialog) {
            AddItemBottomDialog(
                title = data.itemToUpdate?.title,
                onSaveClick = { title -> vm.saveItem(title) },
                onCancel = { vm.onItemUpdateCanceled() },
                isEdit = data.itemToUpdate != null
            )
        }
        LaunchedEffect(data.toastMessage) {
            data.toastMessage?.let { message ->
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
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
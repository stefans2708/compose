package com.sentics.composetest.grid

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sentics.composetest.grid.data.GridData
import com.sentics.composetest.grid.data.GridItem
import com.sentics.composetest.grid.data.GridItemView
import com.sentics.composetest.grid.data.GridSection
import com.sentics.composetest.grid.data.toLargeGridItem
import com.sentics.composetest.grid.data.toSmallGridItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GridViewModel : ViewModel() {

    private val _state = MutableStateFlow(GridState())
    val state: StateFlow<GridState> = _state

    init {
        reloadData()
    }

    fun onEditItemsClick(item: GridItemView) {
        _state.update {
            it.copy(
                showUpdateDialog = true,
                itemToUpdate = item,
                sectionToUpdate = item.sectionId
            )
        }
    }

    fun onAddItemClick(item: GridItemView) {
        _state.update {
            it.copy(
                showUpdateDialog = true,
                sectionToUpdate = item.sectionId
            )
        }
    }

    fun saveItem(newTitle: String) {
        viewModelScope
            .launch(context = Dispatchers.IO) {
                GridData.saveItem(
                    newTitle = newTitle,
                    itemId = _state.value.itemToUpdate?.id,
                    sectionToUpdate = _state.value.sectionToUpdate
                )

                _state.value = GridState(
                    items = GridData.data.flattenSections(),
                    toastMessage = if (_state.value.itemToUpdate == null) "New Item Added" else "Item updated"
                )
            }
    }

    fun onItemUpdateCanceled() {
        _state.update {
            it.copy(
                showUpdateDialog = false,
                itemToUpdate = null,
                sectionToUpdate = null
            )
        }
    }

    private fun reloadData() {
        _state.value = GridState(items = GridData.data.flattenSections())
    }

    private fun List<GridSection>.flattenSections(): List<GridItemView> =
        this.map { section -> section.extractItems() }.flatten()

    private fun GridSection.extractItems(): List<GridItemView> =
        mutableListOf<GridItemView>().apply {
            add(GridItemView.HeaderItem(title, id))

            for (i in 1..items.size) {
                add(if (i % 3 == 0) items[i - 1].toLargeGridItem(id) else items[i - 1].toSmallGridItem(id))
            }

            add(GridItemView.AddItem(id))
        }
}

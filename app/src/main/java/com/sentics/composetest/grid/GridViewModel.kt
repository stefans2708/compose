package com.sentics.composetest.grid

import androidx.lifecycle.ViewModel
import com.sentics.composetest.grid.data.GridData
import com.sentics.composetest.grid.data.GridItem
import com.sentics.composetest.grid.data.GridSection
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class GridViewModel : ViewModel() {

    private val _items = MutableStateFlow<List<GridSection>>(listOf())
    val gridItems: StateFlow<List<GridSection>> = _items

    init {
        _items.value = GridData.data
    }

}

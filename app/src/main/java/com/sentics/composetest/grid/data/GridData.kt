package com.sentics.composetest.grid.data

import com.sentics.composetest.R
import java.util.UUID

object GridData {
    private var _data = mutableListOf<GridSection>()
    val data: List<GridSection> get() = _data

    init {
        _data = mutableListOf(
            createSection(1, "Workouts", 4),
            createSection(2, "Exercises", 7),
            createSection(3, "Sport", 5),
        )
    }

    fun saveItem(newTitle: String, itemId: String?, sectionToUpdate: Int?) {
        val sectionIndex = _data.indexOfFirst { section -> section.id == sectionToUpdate }
        val section = _data[sectionIndex]

        if (itemId != null) {
            _data[sectionIndex] = section.copy(
                items = section.items.map { if (it.id == itemId) it.copy(title = newTitle) else it }
            )
        } else {
            _data[sectionIndex] = section.copy(
                items = section.items.toMutableList().apply {
                    add(getNextGridItem(section.items.size, newTitle))
                }
            )
        }
    }
}

private val images = listOf(
    R.drawable.ab1_inversions,
    R.drawable.ab2_quick_yoga,
    R.drawable.ab3_stretching,
    R.drawable.ab4_tabata,
    R.drawable.ab5_hiit,
    R.drawable.ab6_pre_natal_yoga,
    R.drawable.fc1_short_mantras,
    R.drawable.fc2_nature_meditations,
    R.drawable.fc3_stress_and_anxiety,
    R.drawable.fc4_self_massage,
    R.drawable.fc5_overwhelmed,
    R.drawable.fc6_nightly_wind_down,
)

private fun createSection(id: Int, title: String, count: Int) =
    GridSection(
        id = id,
        title = title,
        items = mutableListOf<GridItem>()
            .apply { repeat(count) { add(getNextGridItem(it)) } })

private fun getNextGridItem(id: Int, title: String? = null) = GridItem(
    id = UUID.randomUUID().toString(),
    title = title ?: "This is an item title number $id",
    image = images.random()
)

package com.sentics.composetest.grid.data

import com.sentics.composetest.R
import java.util.UUID
import kotlin.random.Random

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


object GridData {
    var data: List<GridSection> = listOf(); private set

    init {
        data = listOf(
            createSection( 1,"Workouts", 4),
            createSection( 2,"Exercises", 7),
            createSection( 3,"Sport", 5),
        )
    }
}


private fun createSection(id:Int, title: String, count: Int): GridSection {
    val result = mutableListOf<GridItem>()
    result.add(GridItem.HeaderItem(title))
    for (i in 1..count) {
        result.add(
            if (i % 3 == 0) {
                GridItem.LargeItem(id = UUID.randomUUID().toString(), "Random large title $i", images.random())
            } else {
                GridItem.SmallItem(id = UUID.randomUUID().toString(), "Random small title $i", images.random())
            }
        )
    }
    result.add(GridItem.AddItem)

    return GridSection(id, title, result)
}
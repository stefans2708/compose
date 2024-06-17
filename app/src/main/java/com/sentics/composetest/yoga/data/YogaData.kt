package com.sentics.composetest.yoga.data

import com.sentics.composetest.R

object YogaData {

    val topWorkouts = listOf(
        R.drawable.ab1_inversions to R.string.soothe_ab1_inversions,
        R.drawable.ab2_quick_yoga to R.string.soothe_ab2_quick_yoga,
        R.drawable.ab3_stretching to R.string.soothe_ab3_stretching,
        R.drawable.ab4_tabata to R.string.soothe_ab4_tabata,
        R.drawable.ab5_hiit to R.string.soothe_ab5_hiit,
        R.drawable.ab6_pre_natal_yoga to R.string.soothe_ab6_pre_natal_yoga
    ).map { DrawableStringPair(it.first, it.second) }

    val favoriteWorkouts = listOf(
        R.drawable.fc1_short_mantras to R.string.soothe_fc1_short_mantras,
        R.drawable.fc2_nature_meditations to R.string.soothe_fc2_nature_meditations,
        R.drawable.fc3_stress_and_anxiety to R.string.soothe_fc3_stress_and_anxiety,
        R.drawable.fc4_self_massage to R.string.soothe_fc4_self_massage,
        R.drawable.fc5_overwhelmed to R.string.soothe_fc5_overwhelmed,
        R.drawable.fc6_nightly_wind_down to R.string.soothe_fc6_nightly_wind_down
    ).map { DrawableStringPair(it.first, it.second) }
}

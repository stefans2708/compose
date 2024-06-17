package com.sentics.composetest.yoga

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sentics.composetest.R
import com.sentics.composetest.ui.theme_soothe.MySootheTheme
import com.sentics.composetest.yoga.section.FavoritesGrid
import com.sentics.composetest.yoga.section.HomeSection
import com.sentics.composetest.yoga.section.TopWorkoutsRow

@Composable
fun YogaScreen(modifier: Modifier = Modifier) {
    Column(modifier.padding(vertical = 16.dp)) {
        SearchBar(modifier = Modifier.padding(horizontal = 16.dp)) {}
        HomeSection(title = R.string.soothe_align_your_body) {
            TopWorkoutsRow()
        }
        HomeSection(title = R.string.soothe_favorite_collections) {
            FavoritesGrid()
        }
    }
}

@Preview
@Composable
private fun YogaScreenPreview() {
    MySootheTheme {
        YogaScreen()
    }
}
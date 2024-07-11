package com.sentics.composetest.yoga.section

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sentics.composetest.R
import com.sentics.composetest.yoga.theme_soothe.MySootheTheme
import com.sentics.composetest.yoga.data.YogaData

@Composable
fun FavoritesGrid(modifier: Modifier = Modifier) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(8.dp),
        modifier = modifier
            .height(120.dp),
    ) {
        items(YogaData.favoriteWorkouts) { item ->
            FavoriteActivityCard(
                image = item.drawable,
                title = item.text
            )
        }
    }
}

@Composable
private fun FavoriteActivityCard(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
    @StringRes title: Int
) {
    Surface(
        modifier = modifier
            .height(56.dp)
            .width(192.dp),
        shape = MaterialTheme.shapes.small,
        color = MaterialTheme.colorScheme.surface
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(56.dp)
            )
            Text(
                text = stringResource(id = title),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 16.dp),
                lineHeight = 16.sp
            )
        }
    }
}

@Preview
@Composable
private fun FavoriteActivitiesElementPreview() {
    MySootheTheme {
        FavoritesGrid()
    }
}

@Preview
@Composable
private fun FavoriteActivityCardPreview() {
    MySootheTheme {
        FavoriteActivityCard(image = R.drawable.fc2_nature_meditations, title = R.string.soothe_fc2_nature_meditations)
    }
}
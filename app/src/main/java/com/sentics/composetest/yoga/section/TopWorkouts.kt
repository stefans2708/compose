package com.sentics.composetest.yoga.section

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sentics.composetest.R
import com.sentics.composetest.ui.theme_soothe.MySootheTheme
import com.sentics.composetest.yoga.data.YogaData

@Composable
fun TopWorkoutsRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(YogaData.topWorkouts) { data ->
            WorkoutItem(image = data.drawable, text = data.text)
        }
    }
}

@Composable
private fun WorkoutItem(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
    @StringRes text: Int
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(id = text),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp)
        )
    }
}

@Preview
@Composable
private fun WorkoutItemPreview() {
    MySootheTheme {
        WorkoutItem(image = R.drawable.ab1_inversions, text = R.string.soothe_ab1_inversions)
    }
}

@Preview
@Composable
private fun TopWorkoutsElementPreview() {
    MySootheTheme {
        TopWorkoutsRow()
    }
}

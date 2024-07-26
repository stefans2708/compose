package com.sentics.composetest.grid.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sentics.composetest.R
import com.sentics.composetest.grid.data.GridItem
import com.sentics.composetest.ui.theme.ComposeTestTheme

@Composable
fun ItemLarge(
    data: GridItem.LargeItem,
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.BottomStart,
        modifier = modifier
            .height(260.dp)
            .padding(8.dp)
    ) {
        Image(
            modifier = Modifier
                .clip(MaterialTheme.shapes.small)
                .fillMaxSize(),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = data.image),
            colorFilter = ColorFilter.tint(
                color = MaterialTheme.colorScheme.secondary.copy(alpha = 0.3f),
                blendMode = BlendMode.Darken
            ),
            contentDescription = data.title
        )
        Text(
            text = data.title,
            style = MaterialTheme.typography.titleMedium.copy(color = MaterialTheme.colorScheme.onPrimary),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview
@Composable
private fun ItemLargePreview() {
    ComposeTestTheme {
        ItemLarge(GridItem.LargeItem("1", "One image", R.drawable.ab4_tabata))
    }
}

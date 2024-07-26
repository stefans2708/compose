package com.sentics.composetest.grid.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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
import com.sentics.composetest.grid.data.GridItemView
import com.sentics.composetest.ui.theme.ComposeTestTheme

@Composable
fun ItemLarge(
    data: GridItemView.LargeItem,
    modifier: Modifier = Modifier,
    onEditItemClick: () -> Unit,
) {
    Box(
        contentAlignment = Alignment.BottomStart,
        modifier = modifier
            .height(260.dp)
            .padding(8.dp)
            .clickable(onClick = onEditItemClick)
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
            style = MaterialTheme.typography.headlineSmall.copy(color = MaterialTheme.colorScheme.onPrimary),
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
        ItemLarge(
            data = GridItemView.LargeItem(
                id = "1",
                title = "One image",
                image = R.drawable.ab4_tabata,
                sectionId = 1
            ),
            onEditItemClick = { }
        )
    }
}

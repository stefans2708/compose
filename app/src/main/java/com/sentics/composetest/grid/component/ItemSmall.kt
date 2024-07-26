package com.sentics.composetest.grid.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sentics.composetest.R
import com.sentics.composetest.grid.data.GridItemView
import com.sentics.composetest.ui.theme.ComposeTestTheme

@Composable
fun ItemSmall(
    data: GridItemView.SmallItem,
    onEditItemClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .height(240.dp)
            .padding(8.dp)
            .clickable { onEditItemClick() },
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary.copy(alpha = 0.3f))
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Image(
                modifier = Modifier
                    .clip(MaterialTheme.shapes.small)
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = data.image),
                contentDescription = data.title
            )
            Text(
                text = data.title,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@Preview
@Composable
private fun ItemSmallPreview() {
    ComposeTestTheme {
        ItemSmall(data = GridItemView.SmallItem(
            id = "1",
            title = "One image",
            sectionId = 1,
            image = R.drawable.ab4_tabata
        ), onEditItemClick = {})
    }
}

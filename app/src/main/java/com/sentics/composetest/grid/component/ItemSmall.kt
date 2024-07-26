package com.sentics.composetest.grid.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
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
import com.sentics.composetest.grid.data.GridItem
import com.sentics.composetest.ui.theme.ComposeTestTheme

@Composable
fun ItemSmall(
    data: GridItem.SmallItem,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .height(240.dp)
            .padding(8.dp)
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
        ItemSmall(GridItem.SmallItem("1", "One image", R.drawable.ab4_tabata))
    }
}

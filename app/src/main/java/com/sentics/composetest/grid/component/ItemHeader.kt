package com.sentics.composetest.grid.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sentics.composetest.grid.data.GridItemView
import com.sentics.composetest.ui.theme.ComposeTestTheme

@Composable
fun ItemHeader(
    data: GridItemView.HeaderItem,
    modifier: Modifier = Modifier
) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier
            .fillMaxWidth(),
    ) {
        Box {
            Text(
                text = data.title,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(vertical = 8.dp)
            )
        }
    }
}

@Preview
@Composable
private fun ItemHeaderPreview() {
    ComposeTestTheme {
        ItemHeader(data = GridItemView.HeaderItem("Section title", 1))
    }
}

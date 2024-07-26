package com.sentics.composetest.grid.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sentics.composetest.R
import com.sentics.composetest.ui.theme.ComposeTestTheme

@Composable
fun ItemAdd(
    onAddClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .height(240.dp)
            .padding(8.dp)
            .clickable(onClick = onAddClick)
        ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_add),
                contentDescription = stringResource(id = R.string.add_to_section),
                modifier = Modifier
                    .size(48.dp)
            )
            Text(
                text = stringResource(id = R.string.add_to_section),
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}

@Preview
@Composable
private fun ItemAddPreview() {
    ComposeTestTheme {
        ItemAdd({})
    }
}

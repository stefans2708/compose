package com.sentics.composetest.unscramble.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sentics.composetest.R
import com.sentics.composetest.yoga.theme_soothe.typography
import com.sentics.composetest.unscramble.ui.theme.UnscrambleTheme

@Composable
fun GameStatus(score: Int, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Text(
            text = stringResource(id = R.string.unscramble_score, score),
            style = typography.headlineMedium,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview
@Composable
private fun GameStatusPreview() {
    UnscrambleTheme {
        GameStatus(score = 23)
    }
}

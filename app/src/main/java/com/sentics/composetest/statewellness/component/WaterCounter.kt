package com.sentics.composetest.statewellness.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sentics.composetest.ui.theme.ComposeTestTheme

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableIntStateOf(0) }

    StatelessCounter(
        count = count,
        onIncrement = { count++ },
        modifier = modifier
    )
}

@Composable
private fun StatelessCounter(
    count: Int,
    onIncrement: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text(text = "You've had $count glasses.")
        }
        Button(
            modifier = Modifier.padding(top = 8.dp),
            enabled = count < 10,
            onClick = onIncrement
        ) {
            Text(text = "Add one")
        }
    }
}


@Preview
@Composable
private fun WaterCounterPreview() {
    ComposeTestTheme {
        WaterCounter()
    }
}

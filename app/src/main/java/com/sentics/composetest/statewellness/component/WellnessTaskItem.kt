package com.sentics.composetest.statewellness.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sentics.composetest.statewellness.data.WellnessTask
import com.sentics.composetest.ui.theme.ComposeTestTheme

@Composable
fun WellnessTaskItem(
    task: WellnessTask,
    onCompletionChange: () -> Unit,
    onDeleteClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "${task.id}: ${task.name}", modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
        )
        Checkbox(
            checked = task.completed,
            onCheckedChange = { onCompletionChange() }
        )
        IconButton(onClick = onDeleteClick) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")
        }
    }
}

@Preview
@Composable
private fun WellnessTaskItemPreview() {
    ComposeTestTheme {
        WellnessTaskItem(WellnessTask(34, "Buy staff", true), onCompletionChange = {}, onDeleteClick = {})
    }
}
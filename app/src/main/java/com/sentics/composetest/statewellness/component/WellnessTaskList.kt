package com.sentics.composetest.statewellness.component

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sentics.composetest.statewellness.data.WellnessTask

@Composable
fun WellnessTaskList(
    list: List<WellnessTask>,
    onTaskRemove: (WellnessTask) -> Unit,
    onTaskComplete: (WellnessTask) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier) {
        items(
            items = list,
            key = { it.id }
        ) { task ->
            WellnessTaskItem(
                task,
                onCompletionChange = { onTaskComplete(task) },
                onDeleteClick = { onTaskRemove(task) }
            )
        }
    }
}

@Preview
@Composable
private fun WellnessTaskListPreview() {

}

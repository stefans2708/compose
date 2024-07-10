package com.sentics.composetest.statewellness

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sentics.composetest.statewellness.component.WaterCounter
import com.sentics.composetest.statewellness.component.WellnessTaskList
import com.sentics.composetest.ui.theme.ComposeTestTheme

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    vm: WellnessViewModel = viewModel()
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier = modifier) {
            WaterCounter()
            WellnessTaskList(
                list = vm.tasks,
                onTaskComplete = { vm.changeTaskStatus(it) },
                onTaskRemove = { vm.removeTask(it) }
            )
        }
    }
}

@Preview
@Composable
private fun WellnessScreenPreview() {
    ComposeTestTheme {
        WellnessScreen()
    }
}

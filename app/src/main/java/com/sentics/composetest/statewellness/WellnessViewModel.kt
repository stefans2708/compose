package com.sentics.composetest.statewellness

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.sentics.composetest.statewellness.data.WellnessData
import com.sentics.composetest.statewellness.data.WellnessTask

class WellnessViewModel : ViewModel() {

    private val _tasks = WellnessData.tasks.toMutableStateList()
    val tasks: List<WellnessTask> get() = _tasks

    fun removeTask(task: WellnessTask) {
        _tasks.remove(task)
    }

    // Remove+add combination or use MutableState<Boolean> for `completed` in WellnessTask
    fun changeTaskStatus(task: WellnessTask) {
        val index = _tasks.indexOf(task)
        val updatedTask = task.copy(completed = !task.completed)
        _tasks.remove(task)
        _tasks.add(index, updatedTask)
    }
}
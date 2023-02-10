package com.saiful.composetodoapp.ui.viewModel

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.saiful.composetodoapp.model.Task
import com.saiful.composetodoapp.ui.repo.TaskRepo

class TaskViewModel : ViewModel() {

    private val _tasks = TaskRepo().getAllTask().toMutableStateList()

    val tasks: List<Task>
        get() = _tasks

    fun remove(task: Task) {
        _tasks.remove(task)
    }

    fun add(taskName: String, taskDes: String, navigateBack: () -> Unit) {
        _tasks.add(
            Task(_tasks.size, taskName, taskDes, false)
        )
        navigateBack.invoke()
    }

    fun toggleCheck(task: Task) {
        _tasks.find { it.id == task.id }?.let { task ->
            task.done = !task.done
        }
    }
}
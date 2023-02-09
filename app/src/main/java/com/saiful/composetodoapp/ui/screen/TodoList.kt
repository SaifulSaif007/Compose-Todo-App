package com.saiful.composetodoapp.ui.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.saiful.composetodoapp.model.Task

@Composable
fun TodoList(
    modifier: Modifier = Modifier,
    list: List<Task>,
    taskUpdate: (Task) -> Unit,
) {
    LazyColumn {
        items(
            items = list,
            key = { task -> task.id }
        ) { task ->
            TodoCard(
                title = task.task,
                description = task.description,
                checked = task.done,
                checkChange = {
                    taskUpdate.invoke(task)
                }
            )
        }
    }

}
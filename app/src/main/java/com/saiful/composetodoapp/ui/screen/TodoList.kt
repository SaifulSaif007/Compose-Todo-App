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
    list: List<Task>
) {
    LazyColumn {
        items(list) { it ->
            TodoCard(
                task = it,
                taskUpdate = {})
        }
    }
}

//Preview
@Preview
@Composable
fun TodoListPreview() {
    TodoList(list = listOf(Task(1, "Jetpack", "compose", true)))
}
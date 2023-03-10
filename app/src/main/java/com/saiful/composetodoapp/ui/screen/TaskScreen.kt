package com.saiful.composetodoapp.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.saiful.composetodoapp.ui.viewModel.TaskViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskScreen(
    taskViewModel: TaskViewModel,
    navigateBack: () -> Unit
) {

    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { Text(text = "Add new task") },
            )
        },
    ) { contentPadding ->
        Box(modifier = Modifier.padding(contentPadding)) {
            Surface {
                TaskScreenContent(taskViewModel, navigateBack)
            }
        }
    }
}

@Composable
fun TaskScreenContent(taskViewModel: TaskViewModel, navigateBack: () -> Unit) {

    var taskName by remember { mutableStateOf("") }
    var taskDescription by remember { mutableStateOf("") }

    Column {
        TextField(
            value = taskName,
            onValueChange = { taskName = it },
            label = { Text(text = "Task Name") },
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 2.dp)
                .fillMaxWidth()
        )

        TextField(
            value = taskDescription,
            onValueChange = { taskDescription = it },
            label = { Text(text = "Task Description") },
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 12.dp)
                .fillMaxWidth()
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .widthIn(100.dp, 400.dp),
                onClick = {
                    taskViewModel.add(taskName, taskDescription, navigateBack)
                }) {
                Text(text = "Add")
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskScreenPreview() {
    TaskScreen(TaskViewModel()) {}
}

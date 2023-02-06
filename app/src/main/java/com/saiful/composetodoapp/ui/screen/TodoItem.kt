package com.saiful.composetodoapp.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saiful.composetodoapp.model.Task

@Composable
fun TodoCard(
    task: Task,
    modifier: Modifier = Modifier,
    taskUpdate: (Task) -> Unit
) {
    TodoCard(
        title = task.task,
        description = task.description,
        checked = task.done,
        checkChange = {
            taskUpdate.invoke(task)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoCard(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    checked: Boolean,
    checkChange: (Boolean) -> Unit
) {
    Surface(modifier) {
        Column(modifier = Modifier.padding(8.dp)) {
            Row(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            ) {
                Checkbox(
                    checked = checked,
                    onCheckedChange = checkChange
                )

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = title,
                        fontSize = 16.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = description,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TodoCardPreview() {
    TodoCard(
        title = "Jetpack Compose",
        description = "learn basic codelabs",
        checked = true,
        checkChange = {}
    )
}
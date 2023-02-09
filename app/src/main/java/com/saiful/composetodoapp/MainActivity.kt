package com.saiful.composetodoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.saiful.composetodoapp.ui.screen.TaskScreen
import com.saiful.composetodoapp.ui.screen.TodoList
import com.saiful.composetodoapp.ui.viewModel.TaskViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController: NavHostController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "list"
            ) {
                composable("list") {
                    HomeScreen { navController.navigate("task") }
                }
                composable("task") {
                    TaskScreen()
                }
            }
        }
    }
}

@Composable
fun TodoListScreen(
    modifier: Modifier = Modifier,
    taskViewModel: TaskViewModel = viewModel()
) {
    TodoList(
        list = taskViewModel.tasks,
        taskUpdate = { task -> taskViewModel.toggleCheck(task) }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onNavigateToTask: () -> Unit
) {
    Scaffold(
        modifier = Modifier,
        topBar = {
            SmallTopAppBar(
                title = { Text(text = "To-Do App") },
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onNavigateToTask) {
                Icon(Icons.Filled.Add, contentDescription = "Add Task")
            }
        }
    ) { contentPadding ->
        Box(modifier = Modifier.padding(contentPadding)) {
            Surface {
                TodoListScreen()
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(onNavigateToTask = {})
}

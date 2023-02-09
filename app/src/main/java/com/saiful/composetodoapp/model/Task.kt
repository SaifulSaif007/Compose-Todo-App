package com.saiful.composetodoapp.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class Task(
    val id: Int,
    val task: String,
    val description: String,
    initialCheck: Boolean = false,
) {

    var done by mutableStateOf(initialCheck)
}

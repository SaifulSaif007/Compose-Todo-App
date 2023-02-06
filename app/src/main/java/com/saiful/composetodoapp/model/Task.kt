package com.saiful.composetodoapp.model

data class Task(
    val id: Int,
    val task: String,
    val description: String,
    val done: Boolean,
)

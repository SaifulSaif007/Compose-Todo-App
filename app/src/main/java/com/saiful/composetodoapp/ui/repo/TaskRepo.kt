package com.saiful.composetodoapp.ui.repo

import com.saiful.composetodoapp.model.Task

class TaskRepo {

    fun getAllTask() = List(2) { i ->
        Task(id = i, task = "Task # $i", "none", false)
    }
}
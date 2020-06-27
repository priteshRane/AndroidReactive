package com.ransoft.androidreactive.coadingwithmitch.data

import com.ransoft.androidreactive.coadingwithmitch.data.modal.Task

class DataSource {
    fun createTaskList() : List<Task> {
        val tasks = ArrayList<Task>()
        tasks.add(Task("Take out the trash", true, 3));
        tasks.add(Task("Walk the dog", false, 2))
        tasks.add(Task("Make my bed", true, 1))
        tasks.add(Task("Unload the dishwasher", false, 0))
        tasks.add(Task("Make dinner", true, 5))
        return tasks
    }
}
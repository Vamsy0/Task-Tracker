package com.vamsy.task_tracker.service;


import com.vamsy.task_tracker.entity.Task;

import java.util.List;


public interface TaskService {

    public List<Task> getAllTasks();


    // Retrieve task by id
    public Task getTaskById(Long id);

    // Create a new Task

    public Task createTask(Task task);

    // Update an existing Task

    public Task updateTask (Long id, Task updatedTask);

    // Delete a task

    public void deleteTask(Long id);
}

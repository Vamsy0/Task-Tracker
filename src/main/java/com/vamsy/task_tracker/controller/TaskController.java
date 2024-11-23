package com.vamsy.task_tracker.controller;

import com.vamsy.task_tracker.entity.Task;
import com.vamsy.task_tracker.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    //Constructor Injection
    public TaskController(TaskService theTaskService) {
        this.taskService = theTaskService;
    }

    // Get all tasks
    @GetMapping("/list")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }


    // Get a task by ID
    @GetMapping("show/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
        try{
            Task task = taskService.getTaskById(id);
            return new ResponseEntity<>(task, HttpStatus.OK);
        }
        catch (RuntimeException e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    // Create a task
    @PostMapping("/save")
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        Task createdTask = taskService.createTask(task);
        return new ResponseEntity<>(createdTask,HttpStatus.CREATED);
    }


    // update an existing task
    @PutMapping("/save/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task updatedTask){
        try {
            Task task = taskService.updateTask(id, updatedTask);
            return new ResponseEntity<>(task, HttpStatus.OK);
        }
        catch (RuntimeException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // delete a task
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable Long id){
        try {
            taskService.deleteTask(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

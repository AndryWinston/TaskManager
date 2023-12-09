package com.alexeykalitin.taskmanager.controller;




import com.alexeykalitin.taskmanager.domain.entity.Task;
import com.alexeykalitin.taskmanager.services.TaskServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/TaskManager")
public class MyController {
    @Autowired
    private TaskServise taskServise;
    @GetMapping("/tasks")
    public List<Task> showAllTasks() {
        return taskServise.getAllTasks();
    }
    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable int id){
        return taskServise.getTask(id);
    }
    @PostMapping("/tasks")
    public Task addNewTask(@RequestBody Task task){
        taskServise.saveTask(task);
        return task;
    }
    @PutMapping("/tasks")
    public Task updateTask(Task task){
        taskServise.saveTask(task);
        return task;
    }
    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable int id){
        Task task = taskServise.getTask(id);
        taskServise.deleteTask(id);
        return "Task with ID = " + id + " was deleted!";
    }
}

package com.alexeykalitin.taskmanager.services.TaskService;

import com.alexeykalitin.taskmanager.domain.entity.Task;

import java.util.List;

public interface TaskServise {
    List<Task> getAllTasks();

    void saveTask(Task task);

    Task getTask(int id);

    void deleteTask(int id);
}

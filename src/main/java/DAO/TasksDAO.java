package DAO;

import domain.Task;

import java.util.List;

public interface TasksDAO {
    List<Task> getAllTasks();

    void saveTask(Task task);

    Task getTask(int id);

    void deleteTask(int id);
}

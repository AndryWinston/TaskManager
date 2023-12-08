package services;

import DAO.TasksDAO;
import domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskServiceImpl implements TaskServise{
    @Autowired
    private TasksDAO tasksDAO;
    @Override
    public List<Task> getAllTasks() {
        return tasksDAO.getAllTasks();
    }

    @Override
    public void saveTask(Task task) {
        tasksDAO.saveTask(task);
    }

    @Override
    public Task getTask(int id) {
        return tasksDAO.getTask(id);
    }

    @Override
    public void deleteTask(int id) {
        tasksDAO.deleteTask(id);
    }
}

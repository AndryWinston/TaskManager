package com.alexeykalitin.taskmanager.DAO.ExecutorDAO;

import com.alexeykalitin.taskmanager.domain.entity.Executor;
import com.alexeykalitin.taskmanager.domain.entity.Task;

import java.util.List;

public interface ExecutorDAO {
    List<Executor> getAllExecutors();

    void saveExecutor(Executor executor);

    Executor getExecutor(int id);

    void deleteExecutor(int id);
}

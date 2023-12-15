package com.alexeykalitin.taskmanager.services.ExecutorService;

import com.alexeykalitin.taskmanager.DAO.ExecutorDAO.ExecutorDAO;
import com.alexeykalitin.taskmanager.domain.entity.Executor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExecutorServiceImpl implements ExecutorService {
    @Autowired
    private ExecutorDAO executorDAO;

    @Override
    public List<Executor> getAllExecutors() {
        return executorDAO.getAllExecutors();
    }

    @Override
    public void saveExecutor(Executor executor) {
        executorDAO.saveExecutor(executor);
    }

    @Override
    public Executor getExecutor(int id) {
        return executorDAO.getExecutor(id);
    }

    @Override
    public void deleteExecutor(int id) {
        executorDAO.deleteExecutor(id);
    }
}

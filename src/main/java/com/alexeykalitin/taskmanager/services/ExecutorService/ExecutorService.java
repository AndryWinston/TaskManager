package com.alexeykalitin.taskmanager.services.ExecutorService;

import com.alexeykalitin.taskmanager.domain.entity.Executor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExecutorService {
    List<Executor> getAllExecutors();

    void saveExecutor(Executor executor);

    Executor getExecutor(int id);

    void deleteExecutor(int id);

}

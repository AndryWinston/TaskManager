package com.alexeykalitin.taskmanager.DAO.ExecutorDAO;

import com.alexeykalitin.taskmanager.domain.entity.Executor;
import com.alexeykalitin.taskmanager.domain.entity.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ExecutorDAOImpl implements ExecutorDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Executor> getAllExecutors() {
        Query query = entityManager.createQuery("from Executor");
        return query.getResultList();
    }

    @Override
    public void saveExecutor(Executor executor) {
        Executor newExecutor = entityManager.merge(executor);
        executor.setId(newExecutor.getId());
    }

    @Override
    public Executor getExecutor(int id) {
        return entityManager.find(Executor.class, id);
    }

    @Override
    public void deleteExecutor(int id) {
        Query query = entityManager.createQuery("delete from Executor " + "where id = :executorId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }

}

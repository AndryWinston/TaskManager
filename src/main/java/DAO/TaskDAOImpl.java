package DAO;

import domain.Task;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TaskDAOImpl implements TasksDAO{
    @Autowired
    private EntityManager entityManager;
    @Override
    public List<Task> getAllTasks() {
        Query query = entityManager.createQuery("from Task");
        return query.getResultList();
    }

    @Override
    public void saveTask(Task task) {
        Task newTask = entityManager.merge(task);
        task.setId(newTask.getId());
    }

    @Override
    public Task getTask(int id) {
        return entityManager.find(Task.class, id);
    }

    @Override
    public void deleteTask(int id) {
        Query query = entityManager.createQuery("delete from Task " + "where id = :taskId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}

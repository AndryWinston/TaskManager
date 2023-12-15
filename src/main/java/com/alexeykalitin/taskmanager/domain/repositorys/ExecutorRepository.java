package com.alexeykalitin.taskmanager.domain.repositorys;

import com.alexeykalitin.taskmanager.domain.entity.Executor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExecutorRepository extends JpaRepository<Executor, Integer> {

    Optional<Executor> findByEmail(String email);

}

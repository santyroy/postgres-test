package org.roy.postgrestest.repository;

import org.roy.postgrestest.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}

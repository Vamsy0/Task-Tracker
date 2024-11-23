package com.vamsy.task_tracker.dao;

import com.vamsy.task_tracker.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}

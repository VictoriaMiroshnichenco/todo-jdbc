package com.miroshnichenko.todo.repository;

import com.miroshnichenko.todo.domain.TaskStatus;
import org.springframework.data.repository.CrudRepository;

public interface TaskStatusRepository extends CrudRepository<TaskStatus,String> {
    TaskStatus findByDescription(String description);
}

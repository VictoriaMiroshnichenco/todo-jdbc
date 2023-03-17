package com.miroshnichenko.todo.repository;

import com.miroshnichenko.todo.domain.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends  CrudRepository<ToDo,String> {}

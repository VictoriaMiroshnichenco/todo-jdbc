package com.miroshnichenko.todo.repository;

import com.miroshnichenko.todo.domain.ToDo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "st")
public interface ToDoRepository extends  CrudRepository<ToDo,String> {

}

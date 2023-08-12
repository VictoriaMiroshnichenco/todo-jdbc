package com.miroshnichenko.todo.repository;

import com.miroshnichenko.todo.domain.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,String> {
}

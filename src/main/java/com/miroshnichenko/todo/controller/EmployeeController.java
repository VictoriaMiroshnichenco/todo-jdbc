package com.miroshnichenko.todo.controller;

import com.miroshnichenko.todo.domain.Employee;
import com.miroshnichenko.todo.domain.ToDo;
import com.miroshnichenko.todo.repository.EmployeeRepository;
import com.miroshnichenko.todo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @GetMapping("/employee")
    //If you wanna allow for everyone then simply use.@CrossOrigin
    @CrossOrigin(origins = {"null","http://localhost:3000"})
    public ResponseEntity<Iterable<Employee>> getEmloyees(){
        return ResponseEntity.ok(employeeRepository.findAll());
    }
}

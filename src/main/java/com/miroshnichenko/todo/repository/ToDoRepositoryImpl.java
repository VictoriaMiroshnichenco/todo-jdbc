package com.miroshnichenko.todo.repository;

import com.miroshnichenko.todo.domain.Employee;
import com.miroshnichenko.todo.domain.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jdbc.core.JdbcAggregateOperations;
import org.springframework.data.jdbc.core.convert.JdbcConverter;
import org.springframework.data.jdbc.repository.support.SimpleJdbcRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.mapping.PersistentEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class ToDoRepositoryImpl {
private static String query ="SELECT `to_do`.`id` AS `id`, `to_do`.`created` AS `created`, `to_do`.`modified` AS `modified`, `to_do`.`completed` AS `completed`, `to_do`.`taskstatus` AS `taskstatus`, `to_do`.`description` AS `description`, `owner`.`id` AS `owner_id`, `owner`.`name` AS `owner_name`, `owner`.`about` AS `owner_about`, `owner`.`active` AS `owner_active`, `owner`.`created` AS `owner_created`, `owner`.`modified` AS `owner_modified`\n" +
        "    FROM `to_do`\n" +
        "   LEFT OUTER JOIN `employee` `owner` ON `owner`.`id` = `to_do`.ownerid\n";
@Autowired

EmployeeRepository employeeRepository;
    @PersistenceContext
    private EntityManager entityManager;
    public Iterable<Employee> findAllWithOwner() {




        return employeeRepository.findAll();
    }


}

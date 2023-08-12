package com.miroshnichenko.todo.repository;

import com.miroshnichenko.todo.domain.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
//todo now in development
public class EmployeeRepositoryImpl /*implements EmployeeRepository*/{
    JdbcTemplate jdbcTemplate;


    public <S extends Employee> S save(S entity) {
        return null;
    }


    public <S extends Employee> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }


    public Optional<Employee> findById(String s) {
        return Optional.empty();
    }


    public boolean existsById(String s) {
        return false;
    }


    public Iterable<Employee> findAll() {
        return  jdbcTemplate.query(
                "SELECT COUNT(*) FROM EMPLOYEE", new EmployeeMapper());

    }


    public Iterable<Employee> findAllById(Iterable<String> strings) {
        return null;
    }

    public long count() {
        return 0;
    }


    public void deleteById(String s) {

    }


    public void delete(Employee entity) {

    }


    public void deleteAllById(Iterable<? extends String> strings) {

    }


    public void deleteAll(Iterable<? extends Employee> entities) {

    }


    public void deleteAll() {

    }

    class EmployeeMapper implements RowMapper<Employee> {

        public Employee mapRow(ResultSet resultSet, int i) throws SQLException {

            Employee person = new Employee();
            person.setId(resultSet.getString("id"));
            person.setName(resultSet.getString("name"));
            person.setCreated(resultSet.getTimestamp("created").toLocalDateTime());
            person.setModified(resultSet.getTimestamp("created").toLocalDateTime());
            person.setActive(resultSet.getBoolean("active"));
            person.setAbout(resultSet.getString("about"));
            return person;
        }
    }
}

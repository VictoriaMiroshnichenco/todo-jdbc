package com.miroshnichenko.todo.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Data

@Table(name = "employee" )
public class Employee {

    @NotNull
    @Id

    private String id;
    @NotNull
    @NotBlank
    private String name;
    private String about;
//    @MappedCollection(idColumn = "ownerid")
    //private Set<ToDo> tasks = new HashSet<>();


    private LocalDateTime created;
    private LocalDateTime modified;
    private boolean active;

    //possibly will use for create form
    public Employee(){
        LocalDateTime date = LocalDateTime.now();
        this.id = UUID.randomUUID().toString();
        this.created = date;
        this.modified = date;
    }

    public Employee(String name){
        this();
        this.name = name;
    }

}

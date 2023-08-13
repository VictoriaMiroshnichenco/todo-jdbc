package com.miroshnichenko.todo.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
@Data
@Entity
public class TaskStatus {

    @javax.persistence.Id
    @GeneratedValue
    @NotNull
    @Id

    private String id;
    @NotNull
    @NotBlank
    private String description;

    private LocalDateTime created;
    private LocalDateTime modified;
    private boolean active;
    //private Set<ToDo> tasks;

    public TaskStatus(){
        LocalDateTime date = LocalDateTime.now();
        this.id = UUID.randomUUID().toString();
        this.created = date;
        this.modified = date;
    }

    public TaskStatus(String description){
        this();
        this.description = description;
    }


}

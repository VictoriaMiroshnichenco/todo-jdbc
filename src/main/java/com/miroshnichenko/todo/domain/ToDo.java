package com.miroshnichenko.todo.domain;


import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
//@Entity // this allows to have crud repository by default? but we need one-to-one so I comment it
//and disabled jpa (removed from dependencies)
@Table(name = "to_do" )
//@NoArgsConstructor
public class ToDo {

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
    private boolean completed;
    @Column("taskstatus")
    private String taskStatus;

//    SELECT `to_do`.`id` AS `id`, `to_do`.`created` AS `created`, `to_do`.`modified` AS `modified`, `to_do`.`completed` AS `completed`, `to_do`.`taskstatus` AS `taskstatus`, `to_do`.`description` AS `description`, `owner`.`id` AS `owner_id`, `owner`.`name` AS `owner_name`, `owner`.`about` AS `owner_about`, `owner`.`active` AS `owner_active`, `owner`.`created` AS `owner_created`, `owner`.`modified` AS `owner_modified`
//    FROM `to_do`
//    LEFT OUTER JOIN `employee` `owner` ON `owner`.`id` = `to_do`.ownerid
//@Embedded(onEmpty = Embedded.OnEmpty.USE_NULL)
// EmbeddedEntity embeddedEntity;
//@Transient
//@ManyToOne(cascade= CascadeType.ALL)
//@JoinColumn(name = "id")
//@JoinTable (name = "employee")
//@OneToOne(fetch = FetchType.LAZY)
//@JoinColumn(name = "employeeid", referencedColumnName = "id")
//private Employee employee ;
private String employee ;
    public ToDo(){
        LocalDateTime date = LocalDateTime.now();
        this.id = UUID.randomUUID().toString();
        this.created = date;
        this.modified = date;
    }

    public ToDo(String description){
        this();
        this.description = description;
    }


}

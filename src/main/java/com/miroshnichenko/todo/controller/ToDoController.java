package com.miroshnichenko.todo.controller;

import com.miroshnichenko.todo.domain.Employee;
import com.miroshnichenko.todo.domain.TaskStatus;
import com.miroshnichenko.todo.domain.ToDo;
import com.miroshnichenko.todo.domain.ToDoBuilder;
import com.miroshnichenko.todo.repository.TaskStatusRepository;
import com.miroshnichenko.todo.repository.ToDoRepository;
import com.miroshnichenko.todo.repository.ToDoRepositoryImpl;
import com.miroshnichenko.todo.validation.ToDoValidationError;
import com.miroshnichenko.todo.validation.ToDoValidationErrorBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ToDoController {

    private ToDoRepository toDoRepository;
    private TaskStatusRepository taskStatusRepository;
    @Autowired //temporary if needed - move to constructor
    private ToDoRepositoryImpl toDoRepositoryImpl;


    @Autowired
    public ToDoController(ToDoRepository toDoRepository,TaskStatusRepository taskStatusRepository) {
        this.toDoRepository = toDoRepository;
        this.taskStatusRepository=taskStatusRepository;
    }

    @GetMapping("/todo")
    //If you wanna allow for everyone then simply use.@CrossOrigin
    @CrossOrigin(origins = {"null","http://localhost:3000"})
    public ResponseEntity<Iterable<ToDo>> getToDos(){
        return ResponseEntity.ok(toDoRepository.findAll());
    }
    @GetMapping("/todowithowner")
    //If you wanna allow for everyone then simply use.@CrossOrigin
    @CrossOrigin(origins = {"null","http://localhost:3000"})
    public ResponseEntity<Iterable<Employee>> getToDosWithOwner(){

        return ResponseEntity.ok(toDoRepositoryImpl.findAllWithOwner());
    }

    @GetMapping("/todo/{id}")
    @CrossOrigin
    public ResponseEntity<ToDo> getToDoById(@PathVariable String id){
        Optional<ToDo> toDo = toDoRepository.findById(id);
        if(toDo.isPresent())
            return ResponseEntity.ok(toDo.get());
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/todo/{id}")
    @CrossOrigin
    public ResponseEntity<ToDo> setCompleted(@PathVariable String id){
        Optional<ToDo> toDo = toDoRepository.findById(id);
        if(!toDo.isPresent())
            return ResponseEntity.notFound().build();
        ToDo result = toDo.get();
        result.setCompleted(true);
        toDoRepository.save(result);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().
                buildAndExpand(result.getId()).toUri();
        return ResponseEntity.ok().header("Location",location.toString()).
                build();
    }

   // @RequestMapping(value="/todo/create", method = {RequestMethod.POST,RequestMethod.PUT})
    @PostMapping  ("/todo")
    @CrossOrigin(origins = {"null","http://localhost:3000"})
    public ResponseEntity<?> createToDo(@Valid @RequestBody ToDo toDo, Errors errors){
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(ToDoValidationErrorBuilder.fromBindingErrors(errors));
        }
    if(toDo.getTask_status()==null){
        TaskStatus ts = taskStatusRepository.findByDescription("Defined");
        toDo.setTask_status(ts);
    }

        ToDo result = toDoRepository.save(toDo);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(result.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/todo/{id}")
    @CrossOrigin
    public ResponseEntity<ToDo> deleteToDo(@PathVariable String id){
        toDoRepository.delete(ToDoBuilder.create().withId(id).build());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/todo")
    @CrossOrigin
    public ResponseEntity<ToDo> deleteToDo(@RequestBody ToDo toDo){
        toDoRepository.delete(toDo);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ToDoValidationError handleException(Exception exception) {
        return new ToDoValidationError(exception.getMessage());
    }

}

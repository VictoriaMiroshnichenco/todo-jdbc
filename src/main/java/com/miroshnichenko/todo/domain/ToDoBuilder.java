package com.miroshnichenko.todo.domain;

public class ToDoBuilder {

    private static ToDoBuilder instance = new ToDoBuilder();
    private String id = null;
    private String description = "";
    private String tasksdescription = "";

    private ToDoBuilder(){}

    public static ToDoBuilder create() {
        return instance;
    }

    public ToDoBuilder withDescription(String description){
        this.description = description;
        return instance;
    }
    public ToDoBuilder withStatus(String status){
        this.tasksdescription = status;
        return instance;
    }

    public ToDoBuilder withId(String id){
        this.id = id;
        return instance;
    }

    public ToDo build(){
        ToDo result = new ToDo(this.description);
        result.setTasksdescription(tasksdescription);
        if(id != null)
            result.setId(id);
        return result;
    }

}

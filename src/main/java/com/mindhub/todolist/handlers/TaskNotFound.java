package com.mindhub.todolist.handlers;

public class TaskNotFound extends  RuntimeException{
    public TaskNotFound(String message) {
        super(message);
    }
}
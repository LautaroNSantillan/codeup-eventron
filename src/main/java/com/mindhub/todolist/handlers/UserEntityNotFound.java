package com.mindhub.todolist.handlers;

public class UserEntityNotFound extends RuntimeException{
    public UserEntityNotFound(String message) {
        super(message);
    }
}
package com.mindhub.todolist;
import  com.mindhub.todolist.models.Task;
import  com.mindhub.todolist.models.UserEntity;
import  com.mindhub.todolist.repositories.TaskRepository;
import  com.mindhub.todolist.repositories.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBinit implements CommandLineRunner {

    @Autowired
    UserEntityRepository userEntityRepository;
    @Autowired
    TaskRepository taskRepository;

    @Override
    public void run(String... args) throws Exception {
        UserEntity user = new UserEntity("fdm_13","123456","fdm_13@hotmail.com");
        userEntityRepository.save(user);

        UserEntity user2 = new UserEntity("abqt","654321","abqt@hotmail.com");
        userEntityRepository.save(user2);

        Task task = new Task("Task1","TestDataBase");
        user.addTask(task);
        taskRepository.save(task);
    }
}
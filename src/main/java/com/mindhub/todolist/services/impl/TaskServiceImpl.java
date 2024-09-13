package com.mindhub.todolist.services.impl;

import com.mindhub.todolist.dtos.TaskDTO;
import com.mindhub.todolist.dtos.TaskPostDTO;
import com.mindhub.todolist.handlers.TaskNotFound;
import com.mindhub.todolist.handlers.UserEntityNotFound;
import com.mindhub.todolist.models.Task;
import com.mindhub.todolist.models.UserEntity;
import com.mindhub.todolist.repositories.TaskRepository;
import com.mindhub.todolist.repositories.UserEntityRepository;
import com.mindhub.todolist.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    UserEntityRepository userEntityRepository;


    public List<TaskDTO> getUserEntities(){
        return taskRepository.findAll().stream().map(t->new TaskDTO(t)).toList();
    }

    public TaskDTO getTaskById(long id){
        return taskRepository.findById(id).map(t->new TaskDTO(t)).orElseThrow(()->new TaskNotFound("The task with id "+id+" does not exist."));
    }

    public ResponseEntity<String> addTaskToUser(TaskPostDTO taskPostDTO,long id){
        UserEntity user = userEntityRepository.findById(id).orElseThrow(()->new UserEntityNotFound("The user with id "+id+" does not exist."));
        Task task = new Task(taskPostDTO);
        user.addTask(task);
        taskRepository.save(task);
        userEntityRepository.save(user);
        return ResponseEntity.ok("The new task of the user with id "+id+" was added successfully.");
    }

    public ResponseEntity<String> deleteTask(long id){
        if(!taskRepository.existsById(id)){
            return (ResponseEntity<String>) ResponseEntity.notFound();
        }
        taskRepository.deleteById(id);
        return ResponseEntity.ok("The task with id "+id+" has been deleted.");
    }
}
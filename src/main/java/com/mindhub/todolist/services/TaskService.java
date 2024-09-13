package com.mindhub.todolist.services;

import com.mindhub.todolist.dtos.TaskDTO;
import com.mindhub.todolist.dtos.TaskPostDTO;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TaskService {

    public List<TaskDTO> getUserEntities();

    public TaskDTO getTaskById(long id);

    public ResponseEntity<String> addTaskToUser(TaskPostDTO taskPostDTO, long id);

    public ResponseEntity<String> deleteTask(long id);
}
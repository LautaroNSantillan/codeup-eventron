package com.mindhub.todolist.services;

import com.mindhub.todolist.dtos.UserEntityDTO;
import com.mindhub.todolist.dtos.UserEntityPostDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface UserEntityService {

    public List<UserEntityDTO> getUserEntities();

    public UserEntityDTO getUserEntityById(long id);

    public ResponseEntity<String> postUserEntity(UserEntityPostDTO userEntityPostDTO);

    public ResponseEntity<String> deleteUserEntity(long id);
}
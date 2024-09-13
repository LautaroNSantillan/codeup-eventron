package com.mindhub.todolist.services.impl;

import com.mindhub.todolist.dtos.UserEntityDTO;
import com.mindhub.todolist.dtos.UserEntityPostDTO;
import com.mindhub.todolist.handlers.UserEntityNotFound;
import com.mindhub.todolist.models.UserEntity;
import com.mindhub.todolist.repositories.UserEntityRepository;
import com.mindhub.todolist.services.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserEntityServiceImpl implements UserEntityService {
    @Autowired
    UserEntityRepository userEntityRepository;

    @Override
    public List<UserEntityDTO> getUserEntities() {
        return userEntityRepository.findAll().stream().map(ue->new UserEntityDTO(ue)).toList();
    }

    @Override
    public UserEntityDTO getUserEntityById(long id) {
        return userEntityRepository.findById(id).map(ue->new UserEntityDTO(ue)).orElseThrow(()->new UserEntityNotFound("The user with id "+id+" does not exist."));

    }

    @Override
    public ResponseEntity<String> postUserEntity(UserEntityPostDTO userEntityPostDTO) {
        userEntityRepository.save(new UserEntity(userEntityPostDTO));
        return ResponseEntity.ok("The user was successfully created.");
    }

    @Override
    public ResponseEntity<String> deleteUserEntity(long id) {
        if(!userEntityRepository.existsById(id)){
            return (ResponseEntity<String>) ResponseEntity.notFound();
        }
        userEntityRepository.deleteById(id);
        return ResponseEntity.ok("The user with id "+id+" has been deleted, along with all associated tasks.");
    }
}
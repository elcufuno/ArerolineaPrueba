package com.example.restservice.service;
import com.example.restservice.dto.UserDTO;

import com.example.restservice.entities.UserEntity;
import com.example.restservice.entities.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    private final IUserRepository repository;

    @Autowired
    public UserService(IUserRepository repository) {
        this.repository = repository;
    }

    public List<UserEntity> getUser() {
        return this.repository.findAll();
    }

    public UserEntity getUsuarioPorId(String id) {
        return this.repository.findByIdentification(id);
    }

    public UserEntity findByUserAndPassword(String user, String password) {
        return this.repository.findByUserAndPassword(user, password);
    }

    public UserEntity saveUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUser(userDTO.getUser());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setIdentification(userDTO.getIdentification());
        return this.repository.save(userEntity);
    }

    public void deleteUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUser(userDTO.getUser());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setIdentification(userDTO.getIdentification());
        this.repository.delete(userEntity);
    }

    public void deleteUserPorId(String id) {
        this.repository.deleteByIdentification(id);
    }
}

package com.example.restservice.controller;

import com.example.restservice.dto.UserDTO;
import com.example.restservice.entities.UserEntity;
import com.example.restservice.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUser")
    public List<UserEntity> user() {
        return this.userService.getUser();
    }

    @GetMapping("/getUsuarioPorId2")
    public UserEntity getUsuarioPorId2(@RequestParam String id) {
        return this.userService.getUsuarioPorId(id);
    }

    @GetMapping("/findByUserAndPassword")
    public UserEntity findByUserAndPassword(@RequestParam String user, @RequestParam String password) {
        return this.userService.findByUserAndPassword(user, password);
    }

    @PostMapping(value = "/insertUsuario2")
    public ResponseEntity<String> insertUsuario2(@RequestBody UserDTO request) {
        UserEntity userEntity;
        try {
            userEntity = this.userService.saveUser(request);
            return new ResponseEntity<>((new Gson()).toJson(userEntity), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error guardando el usuario", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/deleteUsuario2")
    public ResponseEntity<String> deleteUsuario2(@RequestBody UserDTO request) {
        try {
            this.userService.deleteUser(request);
            return new ResponseEntity<>("Persona creada con éxito", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error guardando la persona", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

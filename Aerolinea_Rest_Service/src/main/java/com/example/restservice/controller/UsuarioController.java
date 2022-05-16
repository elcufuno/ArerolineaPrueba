package com.example.restservice.controller;

import com.example.restservice.dto.UsuarioDTO;
import com.example.restservice.entities.UsuarioEntity;
import com.example.restservice.service.UsuarioService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/getUsuario")
    public List<UsuarioEntity> getUsuario() {
        return this.usuarioService.getUsuario();
    }

    @GetMapping("/getUsuarioPorId")
    public Optional<UsuarioEntity> getUsuarioPorId(@RequestParam Integer id) {
        return this.usuarioService.getUsuarioPorId(id);
    }

    @PostMapping(value = "/insertUsuario")
    public ResponseEntity<String> insertUsuario(@RequestBody UsuarioDTO request) {
        UsuarioEntity usuarioEntity;
        try {
            usuarioEntity = this.usuarioService.saveUsuario(request);
            return new ResponseEntity<>((new Gson()).toJson(usuarioEntity), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error guardando", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/deleteUsuario")
    public ResponseEntity<String> deleteUsuario(@RequestBody UsuarioDTO request) {
        try {
            this.usuarioService.deleteUsuario(request);
            return new ResponseEntity<>((new Gson()).toJson(new UsuarioEntity()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error Eliminando ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

package com.example.restservice.controller;

import com.example.restservice.dto.TipoUsuarioDTO;
import com.example.restservice.entities.TipoUsuarioEntity;
import com.example.restservice.service.TipoUsuarioService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class TipoUsuarioController {

    private final TipoUsuarioService tipoUsuarioService;

    @Autowired
    public TipoUsuarioController(TipoUsuarioService tipoUsuarioService) {
        this.tipoUsuarioService = tipoUsuarioService;
    }

    @GetMapping("/getTipoUsuario")
    public List<TipoUsuarioEntity> getTipoUsuario() {
        return this.tipoUsuarioService.getTipoUsuario();
    }

    @GetMapping("/getTipoUsuarioPorId")
    public Optional<TipoUsuarioEntity> getTipoUsuarioPorId(@RequestParam Integer id) {
        return this.tipoUsuarioService.getTipoUsuarioPorId(id);
    }

    @PostMapping(value = "/insertTipoUsuario")
    public ResponseEntity<String> insertTipoUsuario(@RequestBody TipoUsuarioDTO request) {
        TipoUsuarioEntity tipoUsuarioEntity;
        try {
            tipoUsuarioEntity = this.tipoUsuarioService.saveTipoUsuario(request);
            return new ResponseEntity<>((new Gson()).toJson(tipoUsuarioEntity), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error guardando", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/deleteTipoUsuario")
    public ResponseEntity<String> deleteTipoUsuario(@RequestBody TipoUsuarioDTO request) {
        try {
            this.tipoUsuarioService.deleteTipoUsuario(request);
            return new ResponseEntity<>((new Gson()).toJson(new TipoUsuarioEntity()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error Eliminando ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

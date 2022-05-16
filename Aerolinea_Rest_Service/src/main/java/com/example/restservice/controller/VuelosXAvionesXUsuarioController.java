package com.example.restservice.controller;

import com.example.restservice.dto.VuelosXAvionesXUsuarioDTO;
import com.example.restservice.entities.VuelosXAvionesXUsuarioEntity;
import com.example.restservice.service.VuelosXAvionesXUsuarioServices;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class VuelosXAvionesXUsuarioController {

    private final VuelosXAvionesXUsuarioServices vuelosXAvionesXUsuarioServices;

    @Autowired
    public VuelosXAvionesXUsuarioController(VuelosXAvionesXUsuarioServices vuelosXAvionesXUsuarioServices) {
        this.vuelosXAvionesXUsuarioServices = vuelosXAvionesXUsuarioServices;
    }

    @GetMapping("/getVuelosXAvionesXUsuario")
    public List<VuelosXAvionesXUsuarioEntity> getVuelosXAvionesXUsuario() {
        return this.vuelosXAvionesXUsuarioServices.getVuelosXAvionesXUsuario();
    }

    @GetMapping("/getVuelosXAvionesXUsuarioPorId")
    public Optional<VuelosXAvionesXUsuarioEntity> getVuelosXAvionesXUsuarioPorId(@RequestParam Integer id) {
        return this.vuelosXAvionesXUsuarioServices.getVuelosXAvionesXUsuarioPorId(id);
    }

    @PostMapping(value = "/insertVuelosXAvionesXUsuario")
    public ResponseEntity<String> insertVuelosXAvionesXUsuario(@RequestBody VuelosXAvionesXUsuarioDTO request) {
        VuelosXAvionesXUsuarioEntity vuelosXAvionesXUsuarioEntity;
        try {
            vuelosXAvionesXUsuarioEntity = this.vuelosXAvionesXUsuarioServices.saveVuelosXAvionesXUsuario(request);
            return new ResponseEntity<>((new Gson()).toJson(vuelosXAvionesXUsuarioEntity), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error guardando", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/deleteVuelosXAvionesXUsuario")
    public ResponseEntity<String> deleteVuelosXAvionesXUsuario(@RequestBody VuelosXAvionesXUsuarioDTO request) {
        try {
            this.vuelosXAvionesXUsuarioServices.deleteVuelosXAvionesXUsuario(request);
            return new ResponseEntity<>((new Gson()).toJson(new VuelosXAvionesXUsuarioEntity()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error Eliminando ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

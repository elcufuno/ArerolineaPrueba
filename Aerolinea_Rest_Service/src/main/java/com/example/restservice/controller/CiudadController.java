package com.example.restservice.controller;

import com.example.restservice.dto.CiudadDTO;
import com.example.restservice.entities.CiudadesEntity;
import com.example.restservice.service.CiudadService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class CiudadController {

    private final CiudadService ciudadService;

    @Autowired
    public CiudadController(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    @GetMapping("/getCiudades")
    public List<CiudadesEntity> getCiudades() {
        return this.ciudadService.getCiudades();
    }

    @GetMapping("/getCiudadPorId")
    public Optional<CiudadesEntity> getCiudadPorId(@RequestParam Integer id) {
        return this.ciudadService.getCiudadPorId(id);
    }

    @PostMapping(value = "/insertCiudad")
    public ResponseEntity<String> insertCiudad(@RequestBody CiudadDTO request) {
        CiudadesEntity ciudadesEntity;
        try {
            ciudadesEntity = this.ciudadService.saveCiudad(request);
            return new ResponseEntity<>((new Gson()).toJson(ciudadesEntity), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error guardando", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/deleteCiudad")
    public ResponseEntity<String> deleteCiudad(@RequestBody CiudadDTO request) {
        try {
            this.ciudadService.deleteCiudad(request);
            return new ResponseEntity<>((new Gson()).toJson(new CiudadesEntity()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error Eliminando ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

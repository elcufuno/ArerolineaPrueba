package com.example.restservice.controller;

import com.example.restservice.dto.AvionDTO;
import com.example.restservice.entities.AvionesEntity;
import com.example.restservice.service.AvionService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class AvionController {

    private final AvionService avionService;

    @Autowired
    public AvionController(AvionService avionService) {
        this.avionService = avionService;
    }

    @GetMapping("/getAviones")
    public List<AvionesEntity> getAviones() {
        return this.avionService.getAviones();
    }

    @GetMapping("/getAvionesPorId")
    public Optional<AvionesEntity> getAvionPorId(@RequestParam Integer id) {
        return this.avionService.getAvionPorId(id);
    }

    @PostMapping(value = "/insertAvion")
    public ResponseEntity<String> insertAvion(@RequestBody AvionDTO request) {
        AvionesEntity avionesEntity;
        try {
            avionesEntity = this.avionService.saveAvion(request);
            return new ResponseEntity<>((new Gson()).toJson(avionesEntity), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error guardando", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/deleteAvion")
    public ResponseEntity<String> deleteAvion(@RequestBody AvionDTO request) {
        try {
            this.avionService.deleteAvion(request);
            return new ResponseEntity<>((new Gson()).toJson(new AvionesEntity()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error Eliminando ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

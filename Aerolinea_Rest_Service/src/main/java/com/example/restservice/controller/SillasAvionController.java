package com.example.restservice.controller;

import com.example.restservice.dto.SillasAvionDTO;
import com.example.restservice.entities.SillasAvionEntity;
import com.example.restservice.service.SillasAvionService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class SillasAvionController {

    private final SillasAvionService sillasAvionService;

    @Autowired
    public SillasAvionController(SillasAvionService sillasAvionService) {
        this.sillasAvionService = sillasAvionService;
    }

    @GetMapping("/getSillasAviones")
    public List<SillasAvionEntity> getSillasAviones() {
        return this.sillasAvionService.getSillasAvion();
    }

    @GetMapping("/getSillasAvionPorId")
    public Optional<SillasAvionEntity> getSillasAvionesPorId(@RequestParam Integer id) {
        return this.sillasAvionService.getSillasAvionPorId(id);
    }

    @PostMapping(value = "/insertSillasAvion")
    public ResponseEntity<String> insertSillasAviones(@RequestBody SillasAvionDTO request) {
        SillasAvionEntity sillasAvionEntity;
        try {
            sillasAvionEntity = this.sillasAvionService.saveSillasAvion(request);
            return new ResponseEntity<>((new Gson()).toJson(sillasAvionEntity), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error guardando", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/deleteSillasAvion")
    public ResponseEntity<String> deleteSillasAvion(@RequestBody SillasAvionDTO request) {
        try {
            this.sillasAvionService.deleteSillasAvion(request);
            return new ResponseEntity<>((new Gson()).toJson(new SillasAvionEntity()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error Eliminando ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

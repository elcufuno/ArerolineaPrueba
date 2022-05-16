package com.example.restservice.controller;

import com.example.restservice.dto.OrigenesXDestinoDTO;
import com.example.restservice.entities.OrigenesXDestinosEntity;
import com.example.restservice.service.OrigenesXDestinoService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class OrigenesXDestinoController {

    private final OrigenesXDestinoService origenesXDestinoService;

    @Autowired
    public OrigenesXDestinoController(OrigenesXDestinoService origenesXDestinoService) {
        this.origenesXDestinoService = origenesXDestinoService;
    }

    @GetMapping("/getOrigenesXDestinos")
    public List<OrigenesXDestinosEntity> getDepartamentos() {
        return this.origenesXDestinoService.getOrigenesXDestino();
    }

    @GetMapping("/getOrigenesXDestinoPorId")
    public Optional<OrigenesXDestinosEntity> getCiudadPorId(@RequestParam Integer id) {
        return this.origenesXDestinoService.getOrigenesXDestinosPorId(id);
    }

    @PostMapping(value = "/insertOrigenesXDestino")
    public ResponseEntity<String> insertOrigenesXDestino(@RequestBody OrigenesXDestinoDTO request) {
        OrigenesXDestinosEntity origenesXDestinosEntity;
        try {
            origenesXDestinosEntity = this.origenesXDestinoService.saveOrigenesXDestinos(request);
            return new ResponseEntity<>((new Gson()).toJson(origenesXDestinosEntity), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error guardando", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/deleteOrigenesXDestino")
    public ResponseEntity<String> deleteOrigenesXDestino(@RequestBody OrigenesXDestinoDTO request) {
        try {
            this.origenesXDestinoService.deleteOrigenesXDestinos(request);
            return new ResponseEntity<>((new Gson()).toJson(new OrigenesXDestinosEntity()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error Eliminando ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

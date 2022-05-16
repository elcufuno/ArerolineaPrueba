package com.example.restservice.controller;

import com.example.restservice.dto.PaisDTO;
import com.example.restservice.entities.PaisesEntity;
import com.example.restservice.service.PaisService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class PaisController {

    private final PaisService paisService;

    @Autowired
    public PaisController(PaisService paisService) {
        this.paisService = paisService;
    }

    @GetMapping("/getPaises")
    public List<PaisesEntity> getDepartamentos() {
        return this.paisService.getPaises();
    }

    @GetMapping("/getPaisPorId")
    public Optional<PaisesEntity> getCiudadPorId(@RequestParam Integer id) {
        return this.paisService.getPaisPorId(id);
    }

    @PostMapping(value = "/insertPais")
    public ResponseEntity<String> insertPais(@RequestBody PaisDTO request) {
        PaisesEntity paisesEntity;
        try {
            paisesEntity = this.paisService.savePais(request);
            return new ResponseEntity<>((new Gson()).toJson(paisesEntity), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error guardando", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/deletePais")
    public ResponseEntity<String> deletePais(@RequestBody PaisDTO request) {
        try {
            this.paisService.deletePais(request);
            return new ResponseEntity<>((new Gson()).toJson(new PaisesEntity()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error Eliminando ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

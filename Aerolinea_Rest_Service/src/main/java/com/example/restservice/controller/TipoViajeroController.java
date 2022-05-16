package com.example.restservice.controller;

import com.example.restservice.dto.TipoViajeroDTO;
import com.example.restservice.entities.TipoViajeroEntity;
import com.example.restservice.service.TipoViajeroService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class TipoViajeroController {

    private final TipoViajeroService tipoViajeroService;

    @Autowired
    public TipoViajeroController(TipoViajeroService tipoViajeroService) {
        this.tipoViajeroService = tipoViajeroService;
    }

    @GetMapping("/getTipoViajero")
    public List<TipoViajeroEntity> getTipoViajero() {
        return this.tipoViajeroService.getTipoViajero();
    }

    @GetMapping("/getTipoViajeroPorId")
    public Optional<TipoViajeroEntity> getTipoViajeroPorId(@RequestParam Integer id) {
        return this.tipoViajeroService.getTipoViajeroPorId(id);
    }

    @PostMapping(value = "/insertTipoViajero")
    public ResponseEntity<String> insertTipoViajero(@RequestBody TipoViajeroDTO request) {
        TipoViajeroEntity tipoViajeroEntity;
        try {
            tipoViajeroEntity = this.tipoViajeroService.saveTipoViajero(request);
            return new ResponseEntity<>((new Gson()).toJson(tipoViajeroEntity), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error guardando", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/deleteTipoViajero")
    public ResponseEntity<String> deleteTipoViajero(@RequestBody TipoViajeroDTO request) {
        try {
            this.tipoViajeroService.deleteTipoViajero(request);
            return new ResponseEntity<>((new Gson()).toJson(new TipoViajeroEntity()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error Eliminando ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

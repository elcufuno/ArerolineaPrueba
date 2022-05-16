package com.example.restservice.controller;


import com.example.restservice.dto.ProgramacionServiciosDTO;
import com.example.restservice.entities.ProgramacionServiciosEntity;
import com.example.restservice.service.ProgramacionServiciosService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class ProgramacionServiciosController {

    private final ProgramacionServiciosService programacionServiciosService;

    @Autowired
    public ProgramacionServiciosController(ProgramacionServiciosService programacionServiciosService) {
        this.programacionServiciosService = programacionServiciosService;
    }

    @GetMapping("/getProgramacionServicios")
    public List<ProgramacionServiciosEntity> getDepartamentos() {
        return this.programacionServiciosService.getProgramacionServicios();
    }

    @GetMapping("/getProgramacionServiciosPorId")
    public Optional<ProgramacionServiciosEntity> getCiudadPorId(@RequestParam Integer id) {
        return this.programacionServiciosService.getProgramacionServiciosPorId(id);
    }

    @PostMapping(value = "/insertProgramacionServicios")
    public ResponseEntity<String> insertCiudad(@RequestBody ProgramacionServiciosDTO request) {
        ProgramacionServiciosEntity programacionServiciosEntity;
        try {
            programacionServiciosEntity = this.programacionServiciosService.saveProgramacionServicios(request);
            return new ResponseEntity<>((new Gson()).toJson(programacionServiciosEntity), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error guardando", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/deleteProgramacionServicios")
    public ResponseEntity<String> deleteCiudad(@RequestBody ProgramacionServiciosDTO request) {
        try {
            this.programacionServiciosService.deleteProgramacionServicios(request);
            return new ResponseEntity<>((new Gson()).toJson(new ProgramacionServiciosEntity()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error Eliminando ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

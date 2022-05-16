package com.example.restservice.controller;

import com.example.restservice.dto.DepartamentoDTO;
import com.example.restservice.entities.DepartamentosEntity;
import com.example.restservice.service.DepartamentosService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class DepartamentoController {

    private final DepartamentosService departamentosService;

    @Autowired
    public DepartamentoController(DepartamentosService departamentosService) {
        this.departamentosService = departamentosService;
    }

    @GetMapping("/getDepartamentos")
    public List<DepartamentosEntity> getDepartamentos() {
        return this.departamentosService.getDepartamentos();
    }

    @GetMapping("/getDepartamentoPorId")
    public Optional<DepartamentosEntity> getCiudadPorId(@RequestParam Integer id) {
        return this.departamentosService.getDepartamentoPorId(id);
    }

    @PostMapping(value = "/insertDepartamento")
    public ResponseEntity<String> insertDepartamento(@RequestBody DepartamentoDTO request) {
        DepartamentosEntity departamentosEntity;
        try {
            departamentosEntity = this.departamentosService.saveDepartamento(request);
            return new ResponseEntity<>((new Gson()).toJson(departamentosEntity), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error guardando", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/deleteDepartamento")
    public ResponseEntity<String> deleteDepartamento(@RequestBody DepartamentoDTO request) {
        try {
            this.departamentosService.deleteDepartamento(request);
            return new ResponseEntity<>((new Gson()).toJson(new DepartamentosEntity()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error Eliminando ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

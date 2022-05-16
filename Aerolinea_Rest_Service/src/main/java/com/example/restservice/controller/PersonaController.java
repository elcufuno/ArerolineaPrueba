package com.example.restservice.controller;

import com.example.restservice.dto.PersonaDTO;
import com.example.restservice.entities.PersonasEntity;
import com.example.restservice.service.PersonaService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class PersonaController {
    private final PersonaService personaService;

    @Autowired
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping("/getPersonas")
    public List<PersonasEntity> getPersona() {
        return this.personaService.getPersona();
    }

    @GetMapping("/getPersonasPorId")
    public Optional<PersonasEntity> getPersonaPorId(@RequestParam String id) {
        return this.personaService.getPersonaPorId(id);
    }

    @PostMapping(value = "/insertPersona")
    public ResponseEntity<String> insertPersona(@RequestBody PersonaDTO request) {
        PersonasEntity personasEntity;
        try {
            personasEntity = this.personaService.savePersona(request);
            return new ResponseEntity<>((new Gson()).toJson(personasEntity), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error guardando la persona", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/deletePersona")
    public ResponseEntity<String> deletePersona(@RequestBody PersonaDTO request) {
        try {
            this.personaService.deletePersona(request);
            return new ResponseEntity<>((new Gson()).toJson(new PersonasEntity()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error guardando la persona", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

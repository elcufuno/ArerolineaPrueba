package com.example.restservice.controller;

import com.example.restservice.dto.TipoDocumentoDTO;
import com.example.restservice.entities.TipoDocumentoEntity;
import com.example.restservice.service.TipoDocumentoService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class TipoDocumentoController {

    private final TipoDocumentoService tipoDocumentoService;

    @Autowired
    public TipoDocumentoController(TipoDocumentoService tipoDocumentoService) {
        this.tipoDocumentoService = tipoDocumentoService;
    }

    @GetMapping("/getTipoDocumento")
    public List<TipoDocumentoEntity> getTipoDocumento() {
        return this.tipoDocumentoService.getTipoDocumento();
    }

    @GetMapping("/getTipoDocumentoPorId")
    public Optional<TipoDocumentoEntity> getTipoDocumentoPorId(@RequestParam Integer id) {
        return this.tipoDocumentoService.getTipoDocumentoPorId(id);
    }

    @PostMapping(value = "/insertTipoDocumento")
    public ResponseEntity<String> insertTipoDocumento(@RequestBody TipoDocumentoDTO request) {
        TipoDocumentoEntity tipoDocumentoEntity;
        try {
            tipoDocumentoEntity = this.tipoDocumentoService.saveTipoDocumento(request);
            return new ResponseEntity<>((new Gson()).toJson(tipoDocumentoEntity), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error guardando", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/deleteTipoDocumento")
    public ResponseEntity<String> deleteTipoDocumento(@RequestBody TipoDocumentoDTO request) {
        try {
            this.tipoDocumentoService.deleteTipoDocumento(request);
            return new ResponseEntity<>((new Gson()).toJson(new TipoDocumentoEntity()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error Eliminando ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

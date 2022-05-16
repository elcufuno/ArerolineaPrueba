package com.example.restservice.service;

import com.example.restservice.dto.OrigenesXDestinoDTO;
import com.example.restservice.entities.OrigenesXDestinosEntity;
import com.example.restservice.entities.repositories.IOrigenesXDestinosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrigenesXDestinoService {

    private final IOrigenesXDestinosRepository iOrigenesXDestinosRepository;

    @Autowired
    public OrigenesXDestinoService(IOrigenesXDestinosRepository iOrigenesXDestinosRepository) {
        this.iOrigenesXDestinosRepository = iOrigenesXDestinosRepository;
    }

    public List<OrigenesXDestinosEntity> getOrigenesXDestino() {
        return this.iOrigenesXDestinosRepository.findAll();
    }

    public Optional<OrigenesXDestinosEntity> getOrigenesXDestinosPorId(Integer id) {
        return this.iOrigenesXDestinosRepository.findById(id);
    }

    public OrigenesXDestinosEntity saveOrigenesXDestinos(OrigenesXDestinoDTO origenesXDestinoDTO) {
        OrigenesXDestinosEntity origenesXDestinosEntity = new OrigenesXDestinosEntity();
        origenesXDestinosEntity.setValorTiquiete(origenesXDestinoDTO.getValorTiquiete());
        origenesXDestinosEntity.setIdCiudadOrigen(origenesXDestinoDTO.getIdCiudadOrigen());
        origenesXDestinosEntity.setIdCiudadDestino(origenesXDestinoDTO.getIdCiudadDestino());
        return this.iOrigenesXDestinosRepository.save(origenesXDestinosEntity);
    }

    public void deleteOrigenesXDestinos(OrigenesXDestinoDTO origenesXDestinoDTO) {
        OrigenesXDestinosEntity origenesXDestinosEntity = new OrigenesXDestinosEntity();
        origenesXDestinosEntity.setValorTiquiete(origenesXDestinoDTO.getValorTiquiete());
        origenesXDestinosEntity.setIdCiudadOrigen(origenesXDestinoDTO.getIdCiudadOrigen());
        origenesXDestinosEntity.setIdCiudadDestino(origenesXDestinoDTO.getIdCiudadDestino());
        this.iOrigenesXDestinosRepository.delete(origenesXDestinosEntity);
    }
}

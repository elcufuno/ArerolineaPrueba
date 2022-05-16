package com.example.restservice.service;

import com.example.restservice.dto.SillasAvionDTO;
import com.example.restservice.entities.SillasAvionEntity;
import com.example.restservice.entities.repositories.ISillasAvionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SillasAvionService {

    private final ISillasAvionRepository iSillasAvionRepository;

    @Autowired
    public SillasAvionService(ISillasAvionRepository iSillasAvionRepository) {
        this.iSillasAvionRepository = iSillasAvionRepository;
    }

    public List<SillasAvionEntity> getSillasAvion() {
        return this.iSillasAvionRepository.findAll();
    }

    public Optional<SillasAvionEntity> getSillasAvionPorId(Integer id) {
        return this.iSillasAvionRepository.findById(id);
    }

    public SillasAvionEntity saveSillasAvion(SillasAvionDTO sillasAvionDTO) {
        SillasAvionEntity sillasAvionEntity = new SillasAvionEntity();
        sillasAvionEntity.setNombre(sillasAvionDTO.getNombre());
        sillasAvionEntity.setNumeroSillas(sillasAvionDTO.getNumeroSillas());
        sillasAvionEntity.setIdAvion(sillasAvionDTO.getIdAvion());

        return this.iSillasAvionRepository.save(sillasAvionEntity);
    }

    public void deleteSillasAvion(SillasAvionDTO sillasAvionDTO) {
        SillasAvionEntity sillasAvionEntity = new SillasAvionEntity();
        sillasAvionEntity.setNombre(sillasAvionDTO.getNombre());
        sillasAvionEntity.setNumeroSillas(sillasAvionDTO.getNumeroSillas());
        sillasAvionEntity.setIdAvion(sillasAvionDTO.getIdAvion());
        this.iSillasAvionRepository.delete(sillasAvionEntity);
    }
}

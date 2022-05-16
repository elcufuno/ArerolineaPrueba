package com.example.restservice.service;

import com.example.restservice.dto.AvionDTO;
import com.example.restservice.entities.AvionesEntity;
import com.example.restservice.entities.repositories.IAvionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AvionService {

    private final IAvionesRepository avionesRepository;

    @Autowired
    public AvionService(IAvionesRepository avionesRepository) {
        this.avionesRepository = avionesRepository;
    }

    public List<AvionesEntity> getAviones() {
        return this.avionesRepository.findAll();
    }

    public Optional<AvionesEntity> getAvionPorId(Integer id) {
        return this.avionesRepository.findById(id);
    }

    public AvionesEntity saveAvion(AvionDTO avionDTO) {
        AvionesEntity avionesEntity = new AvionesEntity();
        avionesEntity.setNombre(avionDTO.getNombre());
        avionesEntity.setCantidadSillas(avionDTO.getCantidadSillas());
        avionesEntity.setCodigoAvion(avionDTO.getCodigoAvion());
        return this.avionesRepository.save(avionesEntity);
    }

    public void deleteAvion(AvionDTO avionDTO) {
        AvionesEntity avionesEntity = new AvionesEntity();
        avionesEntity.setNombre(avionDTO.getNombre());
        avionesEntity.setCantidadSillas(avionDTO.getCantidadSillas());
        avionesEntity.setCodigoAvion(avionDTO.getCodigoAvion());
        this.avionesRepository.delete(avionesEntity);
    }

}

package com.example.restservice.service;

import com.example.restservice.dto.PaisDTO;
import com.example.restservice.entities.PaisesEntity;
import com.example.restservice.entities.repositories.IPaisesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PaisService {

    private final IPaisesRepository iPaisesRepository;

    @Autowired
    public PaisService(IPaisesRepository iPaisesRepository) {
        this.iPaisesRepository = iPaisesRepository;
    }

    public List<PaisesEntity> getPaises() {
        return this.iPaisesRepository.findAll();
    }

    public Optional<PaisesEntity> getPaisPorId(Integer id) {
        return this.iPaisesRepository.findById(id);
    }

    public PaisesEntity savePais(PaisDTO paisDTO) {
        PaisesEntity paisesEntity = new PaisesEntity();
        paisesEntity.setNombre(paisDTO.getNombre());
        paisesEntity.setOperacioEstado(paisDTO.getOperacioEstado());
        paisesEntity.setRequiereVisa(paisDTO.getRequiereVisa());
        return this.iPaisesRepository.save(paisesEntity);
    }

    public void deletePais(PaisDTO paisDTO) {
        PaisesEntity paisesEntity = new PaisesEntity();
        paisesEntity.setNombre(paisDTO.getNombre());
        paisesEntity.setOperacioEstado(paisDTO.getOperacioEstado());
        paisesEntity.setRequiereVisa(paisDTO.getRequiereVisa());
        this.iPaisesRepository.delete(paisesEntity);
    }
}

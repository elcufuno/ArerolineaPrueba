package com.example.restservice.service;

import com.example.restservice.dto.DepartamentoDTO;
import com.example.restservice.entities.DepartamentosEntity;
import com.example.restservice.entities.repositories.IDepartamentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DepartamentosService {

    private final IDepartamentosRepository departamentosRepository;

    @Autowired
    public DepartamentosService(IDepartamentosRepository departamentosRepository) {
        this.departamentosRepository = departamentosRepository;
    }

    public List<DepartamentosEntity> getDepartamentos() {
        return this.departamentosRepository.findAll();
    }

    public Optional<DepartamentosEntity> getDepartamentoPorId(Integer id) {
        return this.departamentosRepository.findById(id);
    }

    public DepartamentosEntity saveDepartamento(DepartamentoDTO departamentoDTO) {
        DepartamentosEntity departamentosEntity = new DepartamentosEntity();
        departamentosEntity.setNombre(departamentoDTO.getNombre());
        departamentosEntity.setIdPais(departamentoDTO.getIdPais());
        return this.departamentosRepository.save(departamentosEntity);
    }

    public void deleteDepartamento(DepartamentoDTO departamentoDTO) {
        DepartamentosEntity departamentosEntity = new DepartamentosEntity();
        departamentosEntity.setNombre(departamentoDTO.getNombre());
        departamentosEntity.setIdPais(departamentoDTO.getIdPais());
        this.departamentosRepository.delete(departamentosEntity);
    }
}

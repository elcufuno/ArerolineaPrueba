package com.example.restservice.service;

import com.example.restservice.dto.CiudadDTO;
import com.example.restservice.entities.CiudadesEntity;
import com.example.restservice.entities.repositories.ICiudadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CiudadService {

    private final ICiudadesRepository ciudadesRepository;

    @Autowired
    public CiudadService(ICiudadesRepository ciudadesRepository) {
        this.ciudadesRepository = ciudadesRepository;
    }

    public List<CiudadesEntity> getCiudades() {
        return this.ciudadesRepository.findAll();
    }

    public Optional<CiudadesEntity> getCiudadPorId(Integer id) {
        return this.ciudadesRepository.findById(id);
    }

    public CiudadesEntity saveCiudad(CiudadDTO ciudadDTO) {
        CiudadesEntity ciudadesEntity = new CiudadesEntity();
        ciudadesEntity.setNombre(ciudadDTO.getNombre());
        ciudadesEntity.setIdDepartamento(ciudadDTO.getIdDepartamento());
        return this.ciudadesRepository.save(ciudadesEntity);
    }

    public void deleteCiudad(CiudadDTO ciudadDTO) {
        CiudadesEntity ciudadesEntity = new CiudadesEntity();
        ciudadesEntity.setNombre(ciudadDTO.getNombre());
        ciudadesEntity.setIdDepartamento(ciudadDTO.getIdDepartamento());
        this.ciudadesRepository.delete(ciudadesEntity);
    }
}

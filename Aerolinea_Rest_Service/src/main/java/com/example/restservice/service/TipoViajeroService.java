package com.example.restservice.service;

import com.example.restservice.dto.TipoViajeroDTO;
import com.example.restservice.entities.TipoViajeroEntity;
import com.example.restservice.entities.repositories.ITipoViajeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TipoViajeroService {

    private final ITipoViajeroRepository iTipoViajeroRepository;

    @Autowired
    public TipoViajeroService(ITipoViajeroRepository iTipoViajeroRepository) {
        this.iTipoViajeroRepository = iTipoViajeroRepository;
    }

    public List<TipoViajeroEntity> getTipoViajero() {
        return this.iTipoViajeroRepository.findAll();
    }

    public Optional<TipoViajeroEntity> getTipoViajeroPorId(Integer id) {
        return this.iTipoViajeroRepository.findById(id);
    }

    public TipoViajeroEntity saveTipoViajero(TipoViajeroDTO tipoViajeroDTO) {
        TipoViajeroEntity tipoViajeroEntity = new TipoViajeroEntity();
        tipoViajeroEntity.setNombre(tipoViajeroDTO.getNombre());
        return this.iTipoViajeroRepository.save(tipoViajeroEntity);
    }

    public void deleteTipoViajero(TipoViajeroDTO tipoViajeroDTO) {
        TipoViajeroEntity tipoViajeroEntity = new TipoViajeroEntity();
        tipoViajeroEntity.setNombre(tipoViajeroDTO.getNombre());
        this.iTipoViajeroRepository.delete(tipoViajeroEntity);
    }
}

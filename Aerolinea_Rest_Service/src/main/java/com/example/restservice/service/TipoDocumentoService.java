package com.example.restservice.service;

import com.example.restservice.dto.TipoDocumentoDTO;
import com.example.restservice.entities.TipoDocumentoEntity;
import com.example.restservice.entities.repositories.ITipoDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TipoDocumentoService {

    private final ITipoDocumentoRepository iTipoDocumentoRepository;

    @Autowired
    public TipoDocumentoService(ITipoDocumentoRepository iTipoDocumentoRepository) {
        this.iTipoDocumentoRepository = iTipoDocumentoRepository;
    }

    public List<TipoDocumentoEntity> getTipoDocumento() {
        return this.iTipoDocumentoRepository.findAll();
    }

    public Optional<TipoDocumentoEntity> getTipoDocumentoPorId(Integer id) {
        return this.iTipoDocumentoRepository.findById(id);
    }

    public TipoDocumentoEntity saveTipoDocumento(TipoDocumentoDTO tipoDocumentoDTO) {
        TipoDocumentoEntity tipoDocumentoEntity = new TipoDocumentoEntity();
        tipoDocumentoEntity.setNombre(tipoDocumentoDTO.getNombre());
        return this.iTipoDocumentoRepository.save(tipoDocumentoEntity);
    }

    public void deleteTipoDocumento(TipoDocumentoDTO tipoDocumentoDTO) {
        TipoDocumentoEntity tipoDocumentoEntity = new TipoDocumentoEntity();
        tipoDocumentoEntity.setNombre(tipoDocumentoDTO.getNombre());
        this.iTipoDocumentoRepository.delete(tipoDocumentoEntity);
    }
}

package com.example.restservice.service;

import com.example.restservice.dto.TipoUsuarioDTO;
import com.example.restservice.entities.TipoUsuarioEntity;
import com.example.restservice.entities.repositories.ITipoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TipoUsuarioService {

    private final ITipoUsuarioRepository iTipoUsuarioRepository;

    @Autowired
    public TipoUsuarioService(ITipoUsuarioRepository iTipoUsuarioRepository) {
        this.iTipoUsuarioRepository = iTipoUsuarioRepository;
    }

    public List<TipoUsuarioEntity> getTipoUsuario() {
        return this.iTipoUsuarioRepository.findAll();
    }

    public Optional<TipoUsuarioEntity> getTipoUsuarioPorId(Integer id) {
        return this.iTipoUsuarioRepository.findById(id);
    }

    public TipoUsuarioEntity saveTipoUsuario(TipoUsuarioDTO tipoUsuarioDTO) {
        TipoUsuarioEntity tipoUsuarioEntity = new TipoUsuarioEntity();
        tipoUsuarioEntity.setNombre(tipoUsuarioDTO.getNombre());
        return this.iTipoUsuarioRepository.save(tipoUsuarioEntity);
    }

    public void deleteTipoUsuario(TipoUsuarioDTO tipoUsuarioDTO) {
        TipoUsuarioEntity tipoUsuarioEntity = new TipoUsuarioEntity();
        tipoUsuarioEntity.setNombre(tipoUsuarioDTO.getNombre());
        this.iTipoUsuarioRepository.delete(tipoUsuarioEntity);
    }
}

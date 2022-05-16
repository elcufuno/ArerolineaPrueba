package com.example.restservice.service;

import com.example.restservice.dto.UsuarioDTO;
import com.example.restservice.entities.UsuarioEntity;
import com.example.restservice.entities.repositories.IUsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    private final IUsuariosRepository iUsuariosRepository;

    @Autowired
    public UsuarioService(IUsuariosRepository iUsuariosRepository) {
        this.iUsuariosRepository = iUsuariosRepository;
    }

    public List<UsuarioEntity> getUsuario() {
        return this.iUsuariosRepository.findAll();
    }

    public Optional<UsuarioEntity> getUsuarioPorId(Integer id) {
        return this.iUsuariosRepository.findById(id);
    }

    public UsuarioEntity saveUsuario(UsuarioDTO usuarioDTO) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setNumeroIdentificacion(usuarioDTO.getNumeroIdentificacion());
        usuarioEntity.setNombres(usuarioDTO.getNombres());
        usuarioEntity.setApellidos(usuarioDTO.getApellidos());
        usuarioEntity.setCelular(usuarioDTO.getCelular());
        usuarioEntity.setCorreo(usuarioDTO.getCorreo());
        usuarioEntity.setEdad(usuarioDTO.getEdad());
        usuarioEntity.setGenero(usuarioDTO.getGenero());
        usuarioEntity.setNumeroVisa(usuarioDTO.getNumeroVisa());
        usuarioEntity.setFechaVencimentoVisa(usuarioDTO.getFechaVencimentoVisa());
        usuarioEntity.setMillasAcomuladas(usuarioDTO.getMillasAcomuladas());
        usuarioEntity.setIdTipoViajero(usuarioDTO.getIdTipoViajero());
        usuarioEntity.setIdTipoDocumento(usuarioDTO.getIdTipoDocumento());
        usuarioEntity.setIdTipoUsuario(usuarioDTO.getIdTipoUsuario());

        return this.iUsuariosRepository.save(usuarioEntity);
    }

    public void deleteUsuario(UsuarioDTO usuarioDTO) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setNumeroIdentificacion(usuarioDTO.getNumeroIdentificacion());
        usuarioEntity.setNombres(usuarioDTO.getNombres());
        usuarioEntity.setApellidos(usuarioDTO.getApellidos());
        usuarioEntity.setCelular(usuarioDTO.getCelular());
        usuarioEntity.setCorreo(usuarioDTO.getCorreo());
        usuarioEntity.setEdad(usuarioDTO.getEdad());
        usuarioEntity.setGenero(usuarioDTO.getGenero());
        usuarioEntity.setNumeroVisa(usuarioDTO.getNumeroVisa());
        usuarioEntity.setFechaVencimentoVisa(usuarioDTO.getFechaVencimentoVisa());
        usuarioEntity.setMillasAcomuladas(usuarioDTO.getMillasAcomuladas());
        usuarioEntity.setIdTipoViajero(usuarioDTO.getIdTipoViajero());
        usuarioEntity.setIdTipoDocumento(usuarioDTO.getIdTipoDocumento());
        usuarioEntity.setIdTipoUsuario(usuarioDTO.getIdTipoUsuario());
        this.iUsuariosRepository.delete(usuarioEntity);
    }
}

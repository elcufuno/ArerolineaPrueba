package com.example.restservice.service;

import com.example.restservice.dto.PersonaDTO;
import com.example.restservice.entities.PersonasEntity;
import com.example.restservice.entities.repositories.IPersonasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonaService {
    private final IPersonasRepository repository;
    private UserService userService;

    @Autowired
    public PersonaService(IPersonasRepository repository, UserService userService) {
        this.userService = userService;
        this.repository = repository;
    }

    public List<PersonasEntity> getPersona() {
        return this.repository.findAll();
    }

    public Optional<PersonasEntity> getPersonaPorId(String id) {
        return this.repository.findById(id);
    }

    public PersonasEntity savePersona(PersonaDTO personaDTO) {
        PersonasEntity personasEntity = new PersonasEntity();
        personasEntity.setNombres(personaDTO.getNombres());
        personasEntity.setDireccion(personaDTO.getDireccion());
        personasEntity.setEdad(personaDTO.getEdad());
        personasEntity.setIdentificacion(personaDTO.getIdentificacion());
        personasEntity.setEmail(personaDTO.getEmail());
        personasEntity.setGenero(personaDTO.getGenero());
        personasEntity.setApellidos(personaDTO.getApellidos());
        return this.repository.save(personasEntity);
    }

    public void deletePersona(PersonaDTO personaDTO) {

        this.userService.deleteUserPorId(personaDTO.getIdentificacion());

        PersonasEntity personasEntity = new PersonasEntity();
        personasEntity.setNombres(personaDTO.getNombres());
        personasEntity.setDireccion(personaDTO.getDireccion());
        personasEntity.setEdad(personaDTO.getEdad());
        personasEntity.setIdentificacion(personaDTO.getIdentificacion());
        personasEntity.setEmail(personaDTO.getEmail());
        personasEntity.setGenero(personaDTO.getGenero());
        this.repository.delete(personasEntity);
    }
}

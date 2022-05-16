package com.example.restservice.service;

import com.example.restservice.dto.ProgramacionServiciosDTO;
import com.example.restservice.entities.ProgramacionServiciosEntity;
import com.example.restservice.entities.repositories.IProgramacionServiciosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProgramacionServiciosService {
    private final IProgramacionServiciosRepository iProgramacionServiciosRepository;

    @Autowired
    public ProgramacionServiciosService(IProgramacionServiciosRepository iProgramacionServiciosRepository) {
        this.iProgramacionServiciosRepository = iProgramacionServiciosRepository;
    }

    public List<ProgramacionServiciosEntity> getProgramacionServicios() {
        return this.iProgramacionServiciosRepository.findAll();
    }

    public Optional<ProgramacionServiciosEntity> getProgramacionServiciosPorId(Integer id) {
        return this.iProgramacionServiciosRepository.findById(id);
    }

    public ProgramacionServiciosEntity saveProgramacionServicios(ProgramacionServiciosDTO paisDTO) {
        ProgramacionServiciosEntity programacionServiciosEntity = new ProgramacionServiciosEntity();
        programacionServiciosEntity.setCiudadOrigen(paisDTO.getCiudadOrigen());
        programacionServiciosEntity.setCiudadODestino(paisDTO.getCiudadODestino());
        programacionServiciosEntity.setFechaSalida(paisDTO.getFechaSalida());
        programacionServiciosEntity.setHoraSalida(paisDTO.getHoraSalida());
        programacionServiciosEntity.setFechaRegreso(paisDTO.getFechaRegreso());
        programacionServiciosEntity.setHoraRegreso(paisDTO.getHoraRegreso());
        programacionServiciosEntity.setEscalaVuelo(paisDTO.getEscalaVuelo());
        programacionServiciosEntity.setCiudadEscala(paisDTO.getCiudadEscala());
        programacionServiciosEntity.setHoraSalidaEscala(paisDTO.getHoraSalidaEscala());
        programacionServiciosEntity.setDuracionVuelo(paisDTO.getDuracionVuelo());

        return this.iProgramacionServiciosRepository.save(programacionServiciosEntity);
    }

    public void deleteProgramacionServicios(ProgramacionServiciosDTO paisDTO) {
        ProgramacionServiciosEntity programacionServiciosEntity = new ProgramacionServiciosEntity();
        programacionServiciosEntity.setCiudadOrigen(paisDTO.getCiudadOrigen());
        programacionServiciosEntity.setCiudadODestino(paisDTO.getCiudadODestino());
        programacionServiciosEntity.setFechaSalida(paisDTO.getFechaSalida());
        programacionServiciosEntity.setHoraSalida(paisDTO.getHoraSalida());
        programacionServiciosEntity.setFechaRegreso(paisDTO.getFechaRegreso());
        programacionServiciosEntity.setHoraRegreso(paisDTO.getHoraRegreso());
        programacionServiciosEntity.setEscalaVuelo(paisDTO.getEscalaVuelo());
        programacionServiciosEntity.setCiudadEscala(paisDTO.getCiudadEscala());
        programacionServiciosEntity.setHoraSalidaEscala(paisDTO.getHoraSalidaEscala());
        programacionServiciosEntity.setDuracionVuelo(paisDTO.getDuracionVuelo());
        this.iProgramacionServiciosRepository.delete(programacionServiciosEntity);
    }
}

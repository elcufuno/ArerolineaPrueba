package com.example.restservice.service;

import com.example.restservice.dto.VuelosXAvionesXUsuarioDTO;
import com.example.restservice.entities.VuelosXAvionesXUsuarioEntity;
import com.example.restservice.entities.repositories.IVuelosXAvionesXUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VuelosXAvionesXUsuarioServices {

    private final IVuelosXAvionesXUsuarioRepository iVuelosXAvionesXUsuarioRepository;

    @Autowired
    public VuelosXAvionesXUsuarioServices(IVuelosXAvionesXUsuarioRepository iVuelosXAvionesXUsuarioRepository) {
        this.iVuelosXAvionesXUsuarioRepository = iVuelosXAvionesXUsuarioRepository;
    }

    public List<VuelosXAvionesXUsuarioEntity> getVuelosXAvionesXUsuario() {
        return this.iVuelosXAvionesXUsuarioRepository.findAll();
    }

    public Optional<VuelosXAvionesXUsuarioEntity> getVuelosXAvionesXUsuarioPorId(Integer id) {
        return this.iVuelosXAvionesXUsuarioRepository.findById(id);
    }

    public VuelosXAvionesXUsuarioEntity saveVuelosXAvionesXUsuario(VuelosXAvionesXUsuarioDTO vuelosXAvionesXUsuarioDTO) {
        VuelosXAvionesXUsuarioEntity vuelosXAvionesXUsuarioEntity = new VuelosXAvionesXUsuarioEntity();
        vuelosXAvionesXUsuarioDTO.setDesceuntoValorViajero(vuelosXAvionesXUsuarioDTO.getDesceuntoValorViajero());
        vuelosXAvionesXUsuarioDTO.setDesceuntoValor65(vuelosXAvionesXUsuarioDTO.getDesceuntoValor65());
        vuelosXAvionesXUsuarioDTO.setDesceuntoValor2(vuelosXAvionesXUsuarioDTO.getDesceuntoValor2());
        vuelosXAvionesXUsuarioDTO.setTipoVuelo(vuelosXAvionesXUsuarioDTO.getTipoVuelo());
        vuelosXAvionesXUsuarioDTO.setTitularReserva(vuelosXAvionesXUsuarioDTO.getTitularReserva());
        vuelosXAvionesXUsuarioDTO.setMetodoPago(vuelosXAvionesXUsuarioDTO.getMetodoPago());
        vuelosXAvionesXUsuarioDTO.setSubtotal(vuelosXAvionesXUsuarioDTO.getSubtotal());
        vuelosXAvionesXUsuarioDTO.setTotalPagadoTiquite(vuelosXAvionesXUsuarioDTO.getTotalPagadoTiquite());
        vuelosXAvionesXUsuarioDTO.setIdUsuario(vuelosXAvionesXUsuarioDTO.getIdUsuario());
        vuelosXAvionesXUsuarioDTO.setIdSillasAvion(vuelosXAvionesXUsuarioDTO.getIdSillasAvion());
        vuelosXAvionesXUsuarioDTO.setIdProgramacionServicio(vuelosXAvionesXUsuarioDTO.getIdProgramacionServicio());

        return this.iVuelosXAvionesXUsuarioRepository.save(vuelosXAvionesXUsuarioEntity);
    }

    public void deleteVuelosXAvionesXUsuario(VuelosXAvionesXUsuarioDTO vuelosXAvionesXUsuarioDTO) {
        VuelosXAvionesXUsuarioEntity vuelosXAvionesXUsuarioEntity = new VuelosXAvionesXUsuarioEntity();
        vuelosXAvionesXUsuarioDTO.setDesceuntoValorViajero(vuelosXAvionesXUsuarioDTO.getDesceuntoValorViajero());
        vuelosXAvionesXUsuarioDTO.setDesceuntoValor65(vuelosXAvionesXUsuarioDTO.getDesceuntoValor65());
        vuelosXAvionesXUsuarioDTO.setDesceuntoValor2(vuelosXAvionesXUsuarioDTO.getDesceuntoValor2());
        vuelosXAvionesXUsuarioDTO.setTipoVuelo(vuelosXAvionesXUsuarioDTO.getTipoVuelo());
        vuelosXAvionesXUsuarioDTO.setTitularReserva(vuelosXAvionesXUsuarioDTO.getTitularReserva());
        vuelosXAvionesXUsuarioDTO.setMetodoPago(vuelosXAvionesXUsuarioDTO.getMetodoPago());
        vuelosXAvionesXUsuarioDTO.setSubtotal(vuelosXAvionesXUsuarioDTO.getSubtotal());
        vuelosXAvionesXUsuarioDTO.setTotalPagadoTiquite(vuelosXAvionesXUsuarioDTO.getTotalPagadoTiquite());
        vuelosXAvionesXUsuarioDTO.setIdUsuario(vuelosXAvionesXUsuarioDTO.getIdUsuario());
        vuelosXAvionesXUsuarioDTO.setIdSillasAvion(vuelosXAvionesXUsuarioDTO.getIdSillasAvion());
        vuelosXAvionesXUsuarioDTO.setIdProgramacionServicio(vuelosXAvionesXUsuarioDTO.getIdProgramacionServicio());
        this.iVuelosXAvionesXUsuarioRepository.delete(vuelosXAvionesXUsuarioEntity);
    }
}

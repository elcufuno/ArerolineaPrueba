package com.example.restservice.entities.repositories;

import com.example.restservice.entities.VuelosXAvionesXUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVuelosXAvionesXUsuarioRepository extends JpaRepository<VuelosXAvionesXUsuarioEntity, Integer> {
}

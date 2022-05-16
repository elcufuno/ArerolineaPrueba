package com.example.restservice.entities.repositories;

import com.example.restservice.entities.TipoUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoUsuarioRepository extends JpaRepository<TipoUsuarioEntity, Integer> {
}

package com.example.restservice.entities.repositories;

import com.example.restservice.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuariosRepository extends JpaRepository<UsuarioEntity, Integer> {
}

package com.example.restservice.entities.repositories;

import com.example.restservice.entities.TipoDocumentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoDocumentoRepository extends JpaRepository<TipoDocumentoEntity, Integer> {
}

package com.example.restservice.entities.repositories;

import com.example.restservice.entities.TipoViajeroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoViajeroRepository extends JpaRepository<TipoViajeroEntity, Integer> {
}

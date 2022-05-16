package com.example.restservice.entities.repositories;

import com.example.restservice.entities.CiudadesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICiudadesRepository extends JpaRepository<CiudadesEntity, Integer> {
}

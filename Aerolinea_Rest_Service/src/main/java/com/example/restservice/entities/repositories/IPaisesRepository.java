package com.example.restservice.entities.repositories;

import com.example.restservice.entities.CiudadesEntity;
import com.example.restservice.entities.PaisesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaisesRepository extends JpaRepository<PaisesEntity, Integer> {
}

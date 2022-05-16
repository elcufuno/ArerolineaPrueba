package com.example.restservice.entities.repositories;

import com.example.restservice.entities.ProgramacionServiciosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProgramacionServiciosRepository extends JpaRepository<ProgramacionServiciosEntity, Integer> {
}

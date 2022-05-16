package com.example.restservice.entities.repositories;

import com.example.restservice.entities.AvionesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAvionesRepository extends JpaRepository<AvionesEntity, Integer> {
}

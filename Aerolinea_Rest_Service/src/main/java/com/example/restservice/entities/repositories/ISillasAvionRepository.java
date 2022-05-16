package com.example.restservice.entities.repositories;

import com.example.restservice.entities.SillasAvionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISillasAvionRepository extends JpaRepository<SillasAvionEntity, Integer> {
}

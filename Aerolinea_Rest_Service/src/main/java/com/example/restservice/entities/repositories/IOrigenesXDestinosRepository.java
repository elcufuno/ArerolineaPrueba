package com.example.restservice.entities.repositories;

import com.example.restservice.entities.OrigenesXDestinosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrigenesXDestinosRepository extends JpaRepository<OrigenesXDestinosEntity, Integer> {
}

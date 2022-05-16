package com.example.restservice.entities.repositories;

import com.example.restservice.entities.DepartamentosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepartamentosRepository extends JpaRepository<DepartamentosEntity, Integer> {
}

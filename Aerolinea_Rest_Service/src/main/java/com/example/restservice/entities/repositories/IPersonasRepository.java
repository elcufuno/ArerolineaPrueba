package com.example.restservice.entities.repositories;

import com.example.restservice.entities.PersonasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonasRepository extends JpaRepository<PersonasEntity, String> {
}

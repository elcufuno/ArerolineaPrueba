package com.example.restservice.entities.repositories;

import com.example.restservice.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, String> {

    UserEntity findByIdentification(String identificacion);

    UserEntity findByUserAndPassword(String user, String password);

    void deleteByIdentification(String identificacion);
}

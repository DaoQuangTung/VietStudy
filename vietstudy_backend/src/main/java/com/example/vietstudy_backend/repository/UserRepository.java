package com.example.vietstudy_backend.repository;

import com.example.vietstudy_backend.entity.UserEntity;
import com.example.vietstudy_backend.repository.custom.UserRepositoryCustom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>, UserRepositoryCustom {
    // Các phương thức findBy... do Spring Data JPA tự generate
    UserEntity findByEmail(String email);
}
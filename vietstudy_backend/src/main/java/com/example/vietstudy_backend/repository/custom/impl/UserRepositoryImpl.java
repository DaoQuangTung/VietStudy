package com.example.vietstudy_backend.repository.custom.impl;

import com.example.vietstudy_backend.entity.UserEntity;
import com.example.vietstudy_backend.repository.custom.UserRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserEntity> searchUsers(String keyword) {
    String jpql = "SELECT u FROM UserEntity u WHERE LOWER(u.name) LIKE LOWER(:kw) OR LOWER(u.email) LIKE LOWER(:kw)";
        TypedQuery<UserEntity> query = entityManager.createQuery(jpql, UserEntity.class);
        query.setParameter("kw", "%" + keyword + "%");
        return query.getResultList();
    }
}

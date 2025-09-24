package com.example.vietstudy_backend.repository.custom;

import com.example.vietstudy_backend.entity.UserEntity;

import java.util.List;

public interface UserRepositoryCustom {
    List<UserEntity> searchUsers(String keyword);
}
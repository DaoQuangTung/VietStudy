package com.example.vietstudy_backend.service;

import com.example.vietstudy_backend.entity.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity createUser(UserEntity user);
    UserEntity updateUser(Long id, UserEntity user);
    UserEntity getUserById(Long id);
    List<UserEntity> getAllUsers();
    void deleteUser(Long id);
    List<UserEntity> searchUsers(String keyword);
}

package com.example.vietstudy_backend.service.impl;

import com.example.vietstudy_backend.entity.UserEntity;
import com.example.vietstudy_backend.repository.UserRepository;
import com.example.vietstudy_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public UserEntity updateUser(Long id, UserEntity user) {
        UserEntity existing = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

    // Update necessary fields
    existing.setName(user.getName());
    existing.setEmail(user.getEmail());
    existing.setGender(user.getGender());
    existing.setDob(user.getDob());
    existing.setNativeLanguage(user.getNativeLanguage());
    existing.setPoints(user.getPoints());
    existing.setAvatar(user.getAvatar());
    existing.setUpdatedAt(user.getUpdatedAt());
    existing.setRole(user.getRole());

        return userRepository.save(existing);
    }

    @Override
    public UserEntity getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public List<UserEntity> searchUsers(String keyword) {
        return userRepository.searchUsers(keyword);
    }
}

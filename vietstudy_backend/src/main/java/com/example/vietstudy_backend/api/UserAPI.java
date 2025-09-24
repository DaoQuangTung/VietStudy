package com.example.vietstudy_backend.api;

import com.example.vietstudy_backend.entity.RoleEntity;
import com.example.vietstudy_backend.entity.UserEntity;
import com.example.vietstudy_backend.model.UserRequest;
import com.example.vietstudy_backend.model.UserResponse;
import com.example.vietstudy_backend.repository.RoleRepository;
import com.example.vietstudy_backend.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

// This class is kept for reference but is NOT a Spring controller to avoid duplicate mappings.
// The @RestController and @RequestMapping annotations were removed intentionally.
public class UserAPI {

    private final UserService userService;
    private final ModelMapper modelMapper;
    private final RoleRepository roleRepository;

    public UserAPI(UserService userService, ModelMapper modelMapper, RoleRepository roleRepository) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.roleRepository = roleRepository;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Validated @RequestBody UserRequest request) {
        UserEntity entity = modelMapper.map(request, UserEntity.class);
        if (request.getRoleId() != null) {
            RoleEntity role = roleRepository.findById(request.getRoleId())
                    .orElseThrow(() -> new RuntimeException("Role not found"));
            entity.setRole(role);
        }
        UserEntity saved = userService.createUser(entity);
        return new ResponseEntity<>(modelMapper.map(saved, UserResponse.class), HttpStatus.CREATED);
    }

    @GetMapping
    public List<UserResponse> getAll() {
        return userService.getAllUsers().stream()
                .map(u -> modelMapper.map(u, UserResponse.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable Long id) {
        return modelMapper.map(userService.getUserById(id), UserResponse.class);
    }

    @PutMapping("/{id}")
    public UserResponse update(@PathVariable Long id, @Validated @RequestBody UserRequest request) {
        UserEntity entity = modelMapper.map(request, UserEntity.class);
        if (request.getRoleId() != null) {
            RoleEntity role = roleRepository.findById(request.getRoleId())
                    .orElseThrow(() -> new RuntimeException("Role not found"));
            entity.setRole(role);
        }
        UserEntity updated = userService.updateUser(id, entity);
        return modelMapper.map(updated, UserResponse.class);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<UserResponse> search(@RequestParam String keyword) {
        return userService.searchUsers(keyword).stream()
                .map(u -> modelMapper.map(u, UserResponse.class))
                .collect(Collectors.toList());
    }
}

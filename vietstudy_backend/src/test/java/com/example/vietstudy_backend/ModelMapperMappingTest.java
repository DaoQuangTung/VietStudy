package com.example.vietstudy_backend;

import com.example.vietstudy_backend.config.ModelMapperConfig;
import com.example.vietstudy_backend.entity.RoleEntity;
import com.example.vietstudy_backend.entity.UserEntity;
import com.example.vietstudy_backend.model.UserDTO;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class ModelMapperMappingTest {

    @Test
    void mapsUserEntityToUserDTO() {
        ModelMapper mapper = new ModelMapperConfig().modelMapper();

        RoleEntity role = RoleEntity.builder().id(5L).code("USER").name("User").build();

        UserEntity user = UserEntity.builder()
                .id(10L)
                .name("Test User")
                .email("test@example.com")
                .gender("Other")
                .dob(LocalDate.of(1990,1,1))
                .nativeLanguage("Vietnamese")
                .points(100)
                .avatar("http://example.com/avatar.png")
                .role(role)
                .createdAt(LocalDateTime.now().minusDays(1))
                .updatedAt(LocalDateTime.now())
                .build();

        UserDTO dto = mapper.map(user, UserDTO.class);

        assertEquals(user.getId(), dto.getId());
        assertEquals(user.getName(), dto.getName());
        assertEquals(user.getEmail(), dto.getEmail());
        assertEquals(user.getRole().getId(), dto.getRoleId());
        assertEquals(user.getAvatar(), dto.getAvatar());
        assertNotNull(dto.getCreatedAt());
        assertNotNull(dto.getUpdatedAt());
    }
}

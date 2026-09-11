package com.example.springboot_training2.mapper;

import com.example.springboot_training2.dto.UserRequestDTO;
import com.example.springboot_training2.dto.UserResponseDTO;
import com.example.springboot_training2.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toEntity(UserRequestDTO dto){
        User user = new User();

        user.setContact(dto.getContact());
        user.setAge(dto.getAge());
        user.setName(dto.getName());

        return user;
    }
    public UserResponseDTO toResponseDTO(User user){
        UserResponseDTO dto = new UserResponseDTO();

        dto.setAge(user.getAge());
        dto.setContact(user.getContact());
        dto.setName(user.getName());
        dto.setId(user.getId());

        return dto;
    }

    public void updateEntity(UserRequestDTO dto, User user){
        user.setName(dto.getName());
        user.setAge(dto.getAge());
        user.setContact(dto.getContact());
    }
}

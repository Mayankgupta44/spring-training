package com.example.springboot_training2.service;

import com.example.springboot_training2.dto.UserRequestDTO;
import com.example.springboot_training2.dto.UserResponseDTO;
import com.example.springboot_training2.exception.UserNotFoundException;
import com.example.springboot_training2.mapper.UserMapper;
import com.example.springboot_training2.model.User;
import com.example.springboot_training2.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    public String helloService(){
        return "Hello Service";
    }

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponseDTO saveUser(UserRequestDTO dto){
        User user = userMapper.toEntity(dto);

        User savedUser = userRepository.save(user);

        return userMapper.toResponseDTO(savedUser);
    }

    public List<UserResponseDTO> getAllUsers(){
        List<User> list = userRepository.findAll();
        List<UserResponseDTO> responseList = new ArrayList<>();

        for(User user : list){
            UserResponseDTO dto = userMapper.toResponseDTO(user);

            responseList.add(dto);
        }
        return responseList;
    }

    public UserResponseDTO getUserById(Long id) {
        User user =  userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        return userMapper.toResponseDTO(user);

    }

    @Transactional
    public UserResponseDTO updateUserById(Long id, UserRequestDTO dto){
        User existing = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(("User not found")));

        userMapper.updateEntity(dto, existing);

        return userMapper.toResponseDTO(existing);
    }

    public void deleteUserByIdS(Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException("User not found");
        }
        userRepository.deleteById(id);
    }
}

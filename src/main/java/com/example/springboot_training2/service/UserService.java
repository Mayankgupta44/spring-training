package com.example.springboot_training2.service;

import com.example.springboot_training2.model.User;
import com.example.springboot_training2.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    public String helloService(){
        return "Hello Service";
    }

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User saveUser(User user){
        userRepository.save(user);
        return user;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    public User updateUserById(Long id, User user){
        Optional<User> existingUser = userRepository.findById(id);

        User existing = existingUser.get();

        existing.setName(user.getName());
        existing.setAge(user.getAge());
        existing.setContact(user.getContact());

        return userRepository.save(existing);
    }

    public String deleteUserByIdS(Long id){
        userRepository.deleteById(id);
        return "User deleted";
    }
}

package com.example.springboot_training2.controller;

import com.example.springboot_training2.model.User;
import com.example.springboot_training2.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class HelloController {

    @PostMapping("/hello")
    public String hello(){
        return "Hello SB!";
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        return "hi " + name +" !";
    }

    @GetMapping("/greet")
    public String greet(@RequestParam(defaultValue = "Guest") String name){
        return "Greet " + name +" !";
    }

    @PostMapping("/list")
    public User createUser(@RequestBody User user){
        System.out.println("inside users"+user);
        return user;
    }

    @PutMapping("/update/{name}")
    public User updateUser(@RequestBody User user, @PathVariable String name){
        user.setName(name);
        return user;
    }

    @DeleteMapping("/delete/{name}")
    public String deleteUser(@PathVariable String name){
        return "user" + name + "deleted!";
    }

    private final UserService userService;

    public HelloController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/service")
    public String getServiceHello(){
        return userService.helloService();
    }

}

package com.procesos.tienda.controller;

import com.procesos.tienda.model.User;
import com.procesos.tienda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("users/{id}")
    public User getUserById(@PathVariable String id){
        User user = new User();
        return user;
    }
    @PostMapping("users")
    public User create(@RequestBody User user){
        return userService.createUser(user);
    }
}

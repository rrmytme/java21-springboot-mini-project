package com.dev.spring_boot_java21_mini_project.controller;

import com.dev.spring_boot_java21_mini_project.model.Users;
import com.dev.spring_boot_java21_mini_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    @PostMapping("/admin/adduser")
    public void addUser(@RequestBody Users user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.addUser(user);
    }
}

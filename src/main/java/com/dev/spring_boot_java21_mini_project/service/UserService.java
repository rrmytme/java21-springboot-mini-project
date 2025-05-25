package com.dev.spring_boot_java21_mini_project.service;

import com.dev.spring_boot_java21_mini_project.model.Users;
import com.dev.spring_boot_java21_mini_project.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
@Autowired
    UserDetailsRepository userDetailsRepository;

public void addUser(Users user){
    userDetailsRepository.save(user);
}
}

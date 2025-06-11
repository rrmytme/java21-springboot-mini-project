package com.dev.spring_boot_java21_mini_project.service;

import com.dev.spring_boot_java21_mini_project.model.UserPrincipal;
import com.dev.spring_boot_java21_mini_project.model.Users;
import com.dev.spring_boot_java21_mini_project.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userDetailsRepository.getByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));
        return new UserPrincipal(user);
    }
}

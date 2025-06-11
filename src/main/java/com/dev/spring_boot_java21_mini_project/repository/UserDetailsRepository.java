package com.dev.spring_boot_java21_mini_project.repository;

import com.dev.spring_boot_java21_mini_project.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<Users, Integer> {
    Optional<Users> getByUsername(String username);
}

package com.dev.spring_boot_java21_mini_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    private int id;
    private String username;
    private String password;
    private String role;
}

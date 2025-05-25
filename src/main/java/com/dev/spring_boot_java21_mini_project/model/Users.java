package com.dev.spring_boot_java21_mini_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Users {
    @Id
    private int id;
    private String username;
    private String password;
    private String role;

    public Users() {
    }

    public Users(int id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }
}

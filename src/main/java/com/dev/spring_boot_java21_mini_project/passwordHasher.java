package com.dev.spring_boot_java21_mini_project;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class passwordHasher {
    public static void main(String[] args){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
        String pkey = "admin123";
        String hashedPkey = bCryptPasswordEncoder.encode(pkey);
        System.out.println(hashedPkey);
    }
}

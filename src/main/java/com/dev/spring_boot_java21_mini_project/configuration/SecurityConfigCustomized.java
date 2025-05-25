package com.dev.spring_boot_java21_mini_project.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigCustomized {

    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // 1. Disable CSRF
        http.csrf(customizer -> customizer.disable());
        // 2. Same site strict -> will do this in application.properties
        // 3. Change session -> Stateless
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        // 4. Authenticate and Authorize all requests
        http.authorizeHttpRequests(request -> request
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers(("/user/**")).hasAnyRole("ADMIN","USER")
                .requestMatchers("/public/**").permitAll()
                .anyRequest().authenticated());
        // 5. enable default form login for web logins if require
//        http.formLogin(Customizer.withDefaults());
        // 6. enable basic form login for postman logins
        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails user1 = User
//                .withDefaultPasswordEncoder()
//                .username("test1")
//                .password("test1")
//                .build();
//        UserDetails user2 = User
//                .withDefaultPasswordEncoder()
//                .username("test2")
//                .password("test2")
//                .build();
//        return new InMemoryUserDetailsManager(user1, user2);
//    }



}


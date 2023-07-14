package com.example.demo.config;

import com.example.demo.domain.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository userRepository;
    @Bean
    public void startDB(){
        User u1 = new User(null, "Flavio Augusto1","flavioaom1@yahoo.com.br", "12345", 10.0);
        User u2 = new User(null, "Flavio Augusto1","flavioaom2@yahoo.com.br", "12345", 10.0);

        userRepository.saveAll(List.of(u1, u2));
    }
}

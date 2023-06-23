package com.example.demo.services.impl;

import com.example.demo.domain.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import com.example.demo.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor // este evita ter um construtor injetando as referencias de injeção
@Service
public class UserServiceImpl implements UserService
{
    @Autowired // com o RequiredArgsConstructor, não precisaria utilizar o AutoWired
    private final UserRepository userRepository;

    @Override


    public User findById(Long id) {
       //return new User(null, "Flavio Augusto1","flavioaom@yahoo.com.br", "12345", 10.0);
       // return userRepository.findById(id).orElse(null);  // poderia utilizar tb o OPTMNAL para prever o retorno de null
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Flavio, Não encontrei nada"));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
//        return List.of(
//                new User(null, "Flavio Augusto1","flavioaom@yahoo.com.br", "12345", 10.0),
//                new User(null, "Flavio Augusto2","flavioaom@yahoo.com.br", "12345", 10.0),
//                new User(null, "Flavio Augusto3","flavioaom@yahoo.com.br", "12345", 10.0)
//        );
    }
}
package com.example.demo.services.impl;

import com.example.demo.domain.Dto.UserDto;
import com.example.demo.domain.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.resources.exception.DataIntegrityViolationException;
import com.example.demo.services.UserService;
import com.example.demo.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@RequiredArgsConstructor // este evita ter um construtor injetando as referencias de injeção
@Service
public class UserServiceImpl implements UserService
{
    @Autowired // com o RequiredArgsConstructor, não precisaria utilizar o AutoWired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public User findById(Long id) {
       //return new User(null, "Flavio Augusto1","flavioaom@yahoo.com.br", "12345", 10.0);
       // return userRepository.findById(id).orElse(null);  // poderia utilizar tb o OPTMNAL para prever o retorno de null
        var obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Flavio, Não encontrei nada"));
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

    @Override
    public User create(UserDto obj) {
        findByEmail(obj);
        User user = mapper.map(obj, User.class);
        return userRepository.save(user);
    }

    private void findByEmail(UserDto obj){
        Optional<User> user = UserRepository.findByEmail(obj.getEmail());
        if(user.isPresent()){
            throw new DataIntegrityViolationException("Email já cadastrado Flavio");
        }
    }

}
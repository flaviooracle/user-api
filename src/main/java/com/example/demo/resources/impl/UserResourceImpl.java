package com.example.demo.resources.impl;

import com.example.demo.domain.Dto.UserDto;
import com.example.demo.resources.UserResource;
import com.example.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping(value="/api/users")
public class UserResourceImpl implements UserResource
{
    // refatoramos criando um model mapper config, na pasta config
    // private ModelMapper mapper = new ModelMapper();
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserService userService;
    @Override
    public ResponseEntity<UserDto> findById(Long id) {

        return ResponseEntity.ok().body(mapper.map(userService.findById(id),UserDto.class));
    }

    @Override
    public ResponseEntity<List<UserDto>> findAll() {
        return ResponseEntity
                .ok()
                    .body(userService.findAll()
                        .stream()
                            .map(x -> mapper.map(x, UserDto.class)).collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<List<UserDto>> create(UserDto saveUserDto) {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(userService.create(saveUserDto).getId()).toUri();
        return ResponseEntity
                .created(uri).build();
    }


}

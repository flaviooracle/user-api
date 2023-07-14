package com.example.demo.resources;

import com.example.demo.domain.Dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserResource
{
    @GetMapping(value = "/{id}")
    ResponseEntity<UserDto> findById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<UserDto>> findAll();

    @PostMapping
    ResponseEntity<List<UserDto>> create(@RequestBody UserDto saveUserDto);
}

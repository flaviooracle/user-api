package com.example.demo.resources;

import com.example.demo.domain.Dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserResource
{
    @GetMapping(value = "/{id}")
    ResponseEntity<UserDto> findById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<UserDto>> findAll();

    @PostMapping
    ResponseEntity<List<UserDto>> create(@RequestBody UserDto saveUserDto);

    @PutMapping
    ResponseEntity<UserDto> update(@RequestBody UserDto saveUserDto);

    @DeleteMapping("/{id}")
    ResponseEntity<UserDto> delete(@PathVariable Long id);

}

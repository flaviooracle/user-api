package com.example.demo.domain.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Integer id;
    private String name;
    private String email;
    // @JsonIgnore - ignora o get e o set
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
}

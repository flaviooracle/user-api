package com.example.demo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    // essa é uma forma de injeção de dependencia
    // controlada e gerenciada pelo spring
    // quando requisitado ele injeta e ele mesmo destroi
    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }
}

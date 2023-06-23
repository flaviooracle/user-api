package com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import lombok.*;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;

//import static javax.persistence.GenerationType.IDENTITY;

import static jakarta.persistence.GenerationType.IDENTITY;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
// FAZER COMPARTIVOS DE PROPRIEDADES DA CLASSE
// SÓ CRIARA IMPLICITAMENTE O QUE FOR EXPLICITADO antes de cada propriedade
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name="TB_USER")
public class User
{
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy =IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private Double hourlyPrice;
}

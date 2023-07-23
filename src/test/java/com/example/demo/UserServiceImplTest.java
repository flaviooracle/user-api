package com.example.demo.services.impl;

import com.example.demo.domain.Dto.UserDto;
import com.example.demo.domain.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.resources.exception.DataIntegrityViolationException;
import com.example.demo.services.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceImplTest {

    public static final Long ID = 1L;
    public static final String NAME = "Flavio Augusto1";
    public static final String MAIL = "flavioaom@yahoo.com.br";
    public static final String PASSWORD = "12345";
    public static final double HOURLY_PRICE = 10.0;
    public static final String FLAVIO_N_ENCONTREI_NADA = "Flavio, Não encontrei nada";
    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private ModelMapper mapper;

    private User user;
    private UserDto userDto;
    private Optional<User> optionalUser;
    private List<User> listUser;


    @BeforeEach
    void setUp() {
        startUser();
//        /// this é a classe testada e referenciada com o @InjectMock - nesse caso UserServiceImpl
        MockitoAnnotations.openMocks(this);

    }

    @Test
    void whenFindByIdThenReturnAnUser() {
        //preparo
        when(userRepository.findById(anyLong())).thenReturn(optionalUser);
        // executo
        User response = userService.findById(ID);
//        // Verifico
        assertNotNull(response);
        assertEquals(User.class, response.getClass());
        assertEquals(NAME, response.getName());
    }

    @Test
    void WhenFindByIdNotFindException(){
        when(userRepository.findById(anyLong())).thenThrow(new ObjectNotFoundException(FLAVIO_N_ENCONTREI_NADA));

        try{
            userService.findById(ID);
        }
        catch(Exception ex){
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            assertEquals(ex.getMessage(), FLAVIO_N_ENCONTREI_NADA);
        }
    }



    @Test
    void whenFindAllUserThenReturnAListOfUser() {
        //preparo
        when(userRepository.findAll()).thenReturn(listUser);
        // executo
        List<User> response = userService.findAll();
//        // Verifico
        assertNotNull(response);
        assertEquals(listUser.getClass(), response.getClass()); // verifico se é uma lista do tipo
        assertEquals(User.class, response.get(0).getClass());  // verifico se o item da lista é do tipo user
        assertEquals(listUser.get(0).getName(), response.get(0).getName()); // verifico se o nome retornado é o esperado
        assertEquals(listUser.get(0).getEmail(), response.get(0).getEmail());
        assertEquals(listUser.get(0).getId(), response.get(0).getId());
        assertEquals(2, response.size()); // verifico se retorna a quantidade determinada


    }

    @Test
    void WhenCreateReturnSuccess(){
        when(userRepository.save(any())).thenReturn(user);

        User response =  userService.create(userDto);

        assertNotNull(response);
        assertEquals(User.class, response.getClass());
        assertEquals(ID,response.getId());
        assertEquals(NAME, response.getName());


    }

    @Test
    void WhenCreateReturnAnDataIntegrityViolationException(){
        when(userRepository.findByEmail(anyString())).thenReturn(optionalUser);

        try{
            User response =  userService.create(userDto);
        }
        catch(Exception ex){
            assertEquals(DataIntegrityViolationException.class, ex.getClass());

        }


        assertNotNull(response);
        assertEquals(User.class, response.getClass());
        assertEquals(ID,response.getId());
        assertEquals(NAME, response.getName());


    }

    private void startUser(){
        user = new User(ID, NAME, MAIL, PASSWORD, HOURLY_PRICE);
        userDto = new UserDto(ID, NAME, MAIL, PASSWORD);
        optionalUser = Optional.of(user);
        listUser =  List.of(
                new User(null, "Flavio Augusto1","flavioaom@yahoo.com.br", "12345", 10.0),
			    new User(null, "Flavio Augusto2","flavioaom@yahoo.com.br", "12345", 10.0)
            );
        };



}
//package com.example.demo.services.impl;
//
//import com.example.demo.domain.Dto.UserDto;
//import com.example.demo.domain.User;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Optional;
//
//@SpringBootTest
//class UserServiceImplTest {
//
//    public static final Long ID = 1L;
//    public static final String NAME = "Flavio Augusto1";
//    public static final String MAIL = "flavioaom@yahoo.com.br";
//    public static final String PASSWORD = "12345";
//    public static final double HOURLY_PRICE = 10.0;
////    @InjectMocks
////    private UserServiceImpl userService;
////    @Mock
////    private UserRepository userRepository;
//
//    private User user;
//    private UserDto userDto;
//    private Optional<User> optionalUser;
//
//
//    @BeforeEach
//    void setUp() {
////        startUser();
////        /// this é a classe testada e referenciada com o @InjectMock - nesse caso UserServiceImpl
////        MockitoAnnotations.openMocks(this);
//
//    }
//
//    @Test
//    void whenFindByIdThenReturnAnUser() {
////        //preparo
////        Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(optionalUser);
////        // executo
////        User response = userService.findById(ID);
//////        // Verifico
////        assertNotNull(response);
////        assertEquals(User.class, response.getClass());
////        assertEquals(NAME, response.getName());
//    }
//
//    @Test
//    void findAll() {
//    }
//
//    private void startUser(){
//        user = new User(ID, NAME, MAIL, PASSWORD, HOURLY_PRICE);
//        userDto = new UserDto(ID, NAME, MAIL, PASSWORD, HOURLY_PRICE);
//        optionalUser = Optional.of(user);
//
//        };
//
//
//
//}
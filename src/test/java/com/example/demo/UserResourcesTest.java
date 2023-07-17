//package com.example.demo;
//
//import com.example.demo.domain.Dto.UserDto;
//import com.example.demo.domain.User;
//import com.example.demo.resources.impl.UserResourceImpl;
//import com.example.demo.services.UserService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import java.util.List;
//
//@SpringBootTest
//@ExtendWith(MockitoExtension.class)
//@WebMvcTest(UserResourceImpl.class)
//public class UserResourcesTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Mock
//    // @MockBean
//    private UserService userService;
//
//    @InjectMocks
//    private UserResourceImpl userResourceImpl;
//
//    private List<UserDto> listUserDto;
//    private User user;
//
//    @BeforeEach
//    void beforeEach() {
//        startUser();
//    }
//
//    @Test
//    void whenAccessEndPointGetFindId_Return_ResponseEntity_UserDto() throws Exception {
//
//        Mockito.when(userService.findById(1L)).thenReturn(user);
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/users"))
//
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Flavio"));
////                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("item2"));
//
//    }
//
//    private void startUser() {
//        listUserDto = List.of( new UserDto(1L, "Flavio","flavioaom@gmail.com","123"));
//        user = new User(1L, "Flavio","flavioaom@gmail.com","123",1D);
//    }
//}

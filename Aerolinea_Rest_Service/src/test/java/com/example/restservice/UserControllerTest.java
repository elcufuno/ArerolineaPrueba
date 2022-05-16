package com.example.restservice;

import com.example.restservice.controller.UserController;
import com.example.restservice.entities.UserEntity;
import com.example.restservice.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;

public class UserControllerTest {
    @Mock
    private UserService userService;
    private UserController userController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        userController = new UserController(userService);
    }

    @Test
    public void getUser() throws Exception {
        List<UserEntity> responseEntity = userController.user();
        when(userService.getUser())
                .thenReturn(createData());
    }

    /*private List<UserEntity> createData() {
        List<UserEntity> userEntity = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            UserEntity sf = new UserEntity();
            //sf.setId(new Long(1));
            sf.setName("Jeffri");
            sf.setAddress("Diagonal");
            sf.setGender("M");
            sf.setLastname("Marin");
            sf.setPassword("123");
            sf.setUser("jmarin");
            userEntity.add(sf);
        }
        return userEntity;
    }*/
}

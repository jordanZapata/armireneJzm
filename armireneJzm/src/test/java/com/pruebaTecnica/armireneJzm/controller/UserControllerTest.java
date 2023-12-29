package com.pruebaTecnica.armireneJzm.controller;

import com.pruebaTecnica.armireneJzm.model.UserModel;
import com.pruebaTecnica.armireneJzm.service.UserService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private List<UserModel> users;

    @BeforeEach
    public void setUp() {
        users = new ArrayList<>();

        UserModel user1 = new UserModel();
        user1.setId("1");
        user1.setName("John Doe");
        user1.setEmail("john@example.com");

        UserModel user2 = new UserModel();
        user2.setId("2");
        user2.setName("Alice Smith");
        user2.setEmail("alice@example.com");

        users.add(user1);
        users.add(user2);
    }

    @Test
    public void testGetAllUsers() {
        when(userService.getAllUsers()).thenReturn(users);

        List<UserModel> userList = userController.getAllUsers();
        assertNotNull(userList);
        assertEquals(2, userList.size());
    }

    @Test
    public void testGetUserById() {
        String userId = "1";
        UserModel user = users.get(0);

        when(userService.getUserById(userId)).thenReturn(user);

        ResponseEntity<UserModel> response = userController.getUserById(userId);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        UserModel retrievedUser = response.getBody();
        assertNotNull(retrievedUser);
        assertEquals(userId, retrievedUser.getId());
    }

    @Test
    public void testGetUserById_NotFound() {
        String userId = "100";

        when(userService.getUserById(userId)).thenReturn(null);

        ResponseEntity<UserModel> response = userController.getUserById(userId);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}

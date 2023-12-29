package com.pruebaTecnica.armireneJzm.service;

import com.pruebaTecnica.armireneJzm.service.UserService;
import com.pruebaTecnica.armireneJzm.service.UserServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserServiceImplTest {
    private final UserService userService = new UserServiceImpl();

    @Test
    public void testGetAllUsers() {
        assertEquals(2, userService.getAllUsers().size());
        // Agrega más aserciones según sea necesario
    }

    @Test
    public void testGetUserById() {
        assertNotNull(userService.getUserById("1"));
        // Agrega más aserciones según sea necesario
    }
}

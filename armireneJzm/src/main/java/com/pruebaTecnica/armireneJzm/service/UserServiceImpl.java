package com.pruebaTecnica.armireneJzm.service;

import com.pruebaTecnica.armireneJzm.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private List<UserModel> users = new ArrayList<>();

    public UserServiceImpl() {
        // Simulación de datos de usuarios
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

    @Override
    public List<UserModel> getAllUsers() {
        return users;
    }

    @Override
    public UserModel getUserById(String id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }
}

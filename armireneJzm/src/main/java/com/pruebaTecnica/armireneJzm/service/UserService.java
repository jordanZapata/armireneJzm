package com.pruebaTecnica.armireneJzm.service;

import com.pruebaTecnica.armireneJzm.model.UserModel;

import java.util.List;

public interface UserService {
    List<UserModel> getAllUsers();
    UserModel getUserById(String id);
}

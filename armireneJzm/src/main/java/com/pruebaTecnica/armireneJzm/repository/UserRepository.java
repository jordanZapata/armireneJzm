package com.pruebaTecnica.armireneJzm.repository;

import com.pruebaTecnica.armireneJzm.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel,Long> {
    //Implementación para realizar el buscado de un usuario por medio del email.
    UserModel findByEmail(String email);
}

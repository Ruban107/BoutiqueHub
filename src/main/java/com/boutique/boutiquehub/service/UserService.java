package com.boutique.boutiquehub.service;

import com.boutique.boutiquehub.entity.User;
import jakarta.persistence.Id;

import java.util.List;

public interface UserService {

    User addUser(User user);

    User getUserById(long id);

    User getUserByEmail(String email);

    List<User> getAllUser();

    User updateUser(long id,User user);

    void deleteUserById(long id);
}

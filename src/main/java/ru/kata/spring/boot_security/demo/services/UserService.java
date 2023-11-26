package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUser(int id);

    void saveUser(User user);

    void updateUser(int id, User user);

    void deleteUser(int id);

    User findByEmail(String email);
}

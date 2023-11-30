package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUser(long id);

    void saveUser(User user);

    void updateUser(long id, User user);

    void deleteUser(long id);

    User findByEmail(String email);
}

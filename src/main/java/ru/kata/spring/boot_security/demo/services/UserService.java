package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUser(Integer id);
    User getUserByName(String name);

    void saveUser(User person);

    void updateUser(Integer id, User person);

    void deleteUser(Integer id);
}
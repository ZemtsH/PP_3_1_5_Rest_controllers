package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    User getUser(long id);

    void saveUser(User user);

    void updateUser(long id, User updatedUser);

    void deleteUser(long id);

    User findByEmail(String username);
}
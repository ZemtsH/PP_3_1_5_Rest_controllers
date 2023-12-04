package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.models.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    List<Role> getAllRoles();

    Role getRoleByName(String role);

    Role getRoleById(Long id);

    void addRole(Role role);

    void deleteById(Long id);
}
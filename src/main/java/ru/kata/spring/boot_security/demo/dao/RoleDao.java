package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.models.Role;

import java.util.List;
import java.util.Set;

public interface RoleDao {
    List<Role> getAllRoles();

    Role getRoleById(Long id);

    Role getRoleByName(String role);

    void addRole(Role role);

    void deleteById(Long id);
}

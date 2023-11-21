package ru.kata.spring.boot_security.demo.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.models.*;
import ru.kata.spring.boot_security.demo.repositories.*;

import java.util.Collections;
import java.util.Optional;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        createRoleIfNotExists("ROLE_USER");
        createRoleIfNotExists("ROLE_ADMIN");

        createUser("Vasya", "Pupkin", "v.pupkin@example.com", "1234567890", "password1", "ROLE_USER");
        createUser("Petya", "Petushok", "p.petushok@example.com", "9876543210", "password2", "ROLE_USER");
        createUser("Katya", "Kotik", "k.kotik@example.com", "0123456789", "password3", "ROLE_ADMIN");
    }

    private void createUser(String name, String lastName, String email, String phoneNumber, String password, String roleName) {
        if (userRepository.findUserByName(name) == null) {
            User user = new User();
            user.setName(name);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPhoneNumber(phoneNumber);
            user.setPassword(password);

            Optional<Role> optionalRole = roleRepository.findRoleByName(roleName);
            Role role = optionalRole.orElseThrow(() -> new RuntimeException("Role not found: " + name));

            user.setRole(Collections.singleton(role));

            userRepository.save(user);
        }
    }

    private void createRoleIfNotExists(String name) {
        Optional<Role> existingRoleOptional = roleRepository.findRoleByName(name);
        if (existingRoleOptional.isEmpty()) {
            Role role = new Role(name);
            roleRepository.save(role);
        }
    }
}
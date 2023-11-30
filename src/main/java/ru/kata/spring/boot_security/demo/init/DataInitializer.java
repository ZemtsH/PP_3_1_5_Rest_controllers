//package ru.kata.spring.boot_security.demo.init;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.stereotype.Component;
//import ru.kata.spring.boot_security.demo.models.*;
//import ru.kata.spring.boot_security.demo.services.*;
//
//import javax.annotation.PostConstruct;
//import java.util.*;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//@Component
//public class DataInitializer {
//
//    private final UserService userService;
//    private final RoleService roleService;
//    @Autowired
//    public DataInitializer(UserService userService, RoleService roleService) {
//        this.userService = userService;
//        this.roleService = roleService;
//    }
//
//    @PostConstruct
//    public void run() {
//        roleService.addRole(new Role("ADMIN"));
//        roleService.addRole(new Role("USER"));
//
//        Set<Role> adminRole = new HashSet<>();
//        Set<Role> userRole = new HashSet<>();
//        Set<Role> allRoles = new HashSet<>();
//
//        adminRole.add(roleService.getRoleById(1L));
//        userRole.add(roleService.getRoleById(2L));
//        allRoles.add(roleService.getRoleById(1L));
//        allRoles.add(roleService.getRoleById(2L));
//
//        userService.saveUser(new User("Vasya", "Pupkin", "v.pupkin@example.com", "1234567890", "pass1",adminRole));
//        userService.saveUser(new User("Petya", "Petushok", "p.petushok@example.com", "9876543210", "pass2", userRole));
//        userService.saveUser(new User("Katya", "Kotik", "k.kotik@example.com", "0123456789", "pass3",allRoles));
//        userService.saveUser(new User("user", "user", "user@test.com", "1234567890", "user",userRole));
//        userService.saveUser(new User("admin", "admin", "admin@test.com", "9876543210", "admin", adminRole));
//    }
//}
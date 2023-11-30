package ru.kata.spring.boot_security.demo.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService, UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    @Lazy
    public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> getAllUsers() {
        logger.info("Getting all users from the service.");
        return userDao.getAllUsers();
    }

    @Override
    public User getUser(long id) {
        logger.info("Getting user with ID: {} from the service.", id);
        return userDao.getUser(id);
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        logger.info("Saving user: {} to the service.", user.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.saveUser(user);
    }

    @Transactional
    @Override
    public void updateUser(long id, User user) {
        logger.info("Updating user with ID: {} in the service.", id);
        userDao.updateUser(id, user);
    }

    @Transactional
    @Override
    public void deleteUser(long id) {
        logger.info("Deleting user with ID: {} from the service.", id);
        userDao.deleteUser(id);
    }

    @Override
    public User findByEmail(String email) {
        logger.info("Finding user by email: {} from the service.", email);
        return userDao.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        logger.info("Loading user by username (email): {} from the service.", email);
        return userDao.findByEmail(email);
    }
}
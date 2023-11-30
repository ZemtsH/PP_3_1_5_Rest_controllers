package ru.kata.spring.boot_security.demo.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        logger.info("Getting all users from the database.");
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getUser(long id) {
        logger.info("Getting user with ID: {} from the database.", id);
        return entityManager.find(User.class, id);
    }

    @Override
    public void saveUser(User user) {
        logger.info("Saving user: {} to the database.", user.getUsername());
        entityManager.merge(user);
    }

    @Override
    public void updateUser(long id, User user) {
        logger.info("Updating user with ID: {} in the database.", id);
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(long id) {
        logger.info("Deleting user with ID: {} from the database.", id);
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public User findByEmail(String email) {
        logger.info("Finding user by email: {} from the database.", email);
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.email=:email", User.class).setParameter("email", email);
        return query.getSingleResult();
    }
}
package ru.pelmegov.javashop.dao;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.pelmegov.javashop.api.dao.UserDAO;
import ru.pelmegov.javashop.model.User;

import java.util.List;

@Repository
public class UserDAOImpl extends AbstractDao implements UserDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDAOImpl.class);

    public UserDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public void addUser(User user) {
        getSession().save(user);
        LOGGER.info("User successfully added: {}.", user);
    }

    @Override
    public void updateUser(User user) {
        getSession().update(user);
        LOGGER.info("User successfully update: {}.", user);
    }

    @Override
    public void deleteUserById(Long id) {
        User user = getSession().load(User.class, id);

        if (user != null) {
            LOGGER.info("User successfully removed: {}.", user);
            getSession().delete(user);
        }
    }

    @Override
    public User getUserById(Long id) {
        User user = (User) getSession().createQuery("FROM User WHERE id = :id").setParameter("id", id).uniqueResult();
        LOGGER.info("User successfully loaded: {}.", user);
        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> allUsers() {
        List<User> userList = (List<User>) getSession().createQuery("FROM User ORDER BY id").list();
        LOGGER.info("User list: {}.", userList);

        return userList;
    }
}
package ru.pelmegov.javashop.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.pelmegov.javashop.dao.UserDAO;
import ru.pelmegov.javashop.model.user.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserDAOImpl extends AbstractDAO implements UserDAO {

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
    public void deleteUserById(Integer id) {
        User user = (User) getSession().load(User.class, id);

        if (user != null) {
            LOGGER.info("User successfully removed: {}.", user);
            getSession().delete(user);
        }
    }

    @Override
    public User getUserById(Integer id) {
        User user = (User) getSession().createCriteria(User.class).add(Restrictions.eq("id", id)).uniqueResult();
        LOGGER.info("User successfully loaded: {}.", user);
        return user;
    }

    @Override
    public User getUserByLogin(String login) {
        User user = (User) getSession().createCriteria(User.class).add(Restrictions.eq("login", login)).uniqueResult();
        LOGGER.info("User successfully loaded: {}.", user);
        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<User> getAllUsers() {
        List<User> users = getSession().createCriteria(User.class).addOrder(Order.asc("id")).list();
        LOGGER.info("User list: {}.", users);

        return new HashSet<>(users);
    }
}
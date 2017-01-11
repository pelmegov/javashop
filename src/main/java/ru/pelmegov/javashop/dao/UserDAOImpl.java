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

    private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

    public UserDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public boolean addUser(User user) {
        getSession().save(user);
        return true;
//        logger.info("User successfully added. User details: " + user.getId() + user.getLogin() + user.getName());
    }

    @Override
    public boolean updateUser(User user) {
        getSession().update(user);
        return true;
//        logger.info("User successfully update. User details: " + user.getId() + user.getLogin() + user.getName());
    }

    @Override
    public boolean removeUser(Long id) {
        User user = (User) getSession().load(User.class, id);

        if (user != null) {
            getSession().delete(user);
        }
        return true;
//        logger.info("User successfully removed. User details: " + user);
    }

    @Override
    public User getUserById(Long id) {
        User user = (User) getSession().createQuery("FROM User WHERE id = :id").setParameter("id", id).uniqueResult();
//        logger.info("User successfully loaded. User details: " + user);
        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        List<User> userList = (List<User>) getSession().createQuery("from User").list();

//        for (User user : userList) {
//            logger.warn("User list: " + user);
//        }
        return userList;
    }
}
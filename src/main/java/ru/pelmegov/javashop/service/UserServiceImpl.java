package ru.pelmegov.javashop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pelmegov.javashop.api.dao.UserDAO;
import ru.pelmegov.javashop.api.service.UserService;
import ru.pelmegov.javashop.model.user.User;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDao;

    @Autowired
    public UserServiceImpl(UserDAO userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        this.userDao.addUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        this.userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteUserById(Integer id) {
        this.userDao.deleteUserById(id);
    }

    @Override
    @Transactional
    public User getUserById(Integer id) {
        return this.userDao.getUserById(id);
    }

    @Override
    @Transactional
    public User getUserByLogin(String login) {
        return userDao.getUserByLogin(login);
    }

    @Override
    @Transactional
    public Set<User> getAllUsers() {
        return this.userDao.getAllUsers();
    }
}

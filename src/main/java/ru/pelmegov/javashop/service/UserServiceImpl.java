package ru.pelmegov.javashop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pelmegov.javashop.api.dao.UserDAO;
import ru.pelmegov.javashop.api.service.UserService;
import ru.pelmegov.javashop.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDao;

    @Autowired
    public UserServiceImpl(UserDAO userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public boolean addUser(User user) {
        this.userDao.addUser(user);
        return true;
    }

    @Override
    @Transactional
    public boolean updateUser(User user) {
        this.userDao.updateUser(user);
        return true;
    }

    @Override
    @Transactional
    public boolean removeUser(Long id) {
        this.userDao.removeUser(id);
        return true;
    }

    @Override
    @Transactional
    public User getUserById(Long id) {
        return this.userDao.getUserById(id);
    }

    @Override
    @Transactional
    public List<User> listUsers() {
        return this.userDao.listUsers();
    }
}
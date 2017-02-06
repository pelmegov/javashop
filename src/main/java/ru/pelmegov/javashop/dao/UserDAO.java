package ru.pelmegov.javashop.dao;

import ru.pelmegov.javashop.model.user.User;

import java.util.Set;

public interface UserDAO {

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUserById(Integer id);

    public User getUserById(Integer id);

    public User getUserByLogin(String login);

    public Set<User> getAllUsers();
}

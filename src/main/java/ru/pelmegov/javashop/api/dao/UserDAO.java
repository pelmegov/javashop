package ru.pelmegov.javashop.api.dao;

import ru.pelmegov.javashop.model.User;

import java.util.Set;

public interface UserDAO {

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUserById(Long id);

    public User getUserById(Long id);

    public Set<User> allUsers();

}

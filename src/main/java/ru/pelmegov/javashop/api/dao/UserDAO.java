package ru.pelmegov.javashop.api.dao;


import ru.pelmegov.javashop.model.User;

import java.util.List;

public interface UserDAO {

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUserById(Long id);

    public User getUserById(Long id);

    public List<User> allUsers();

}

package ru.pelmegov.javashop.api.service;

import ru.pelmegov.javashop.model.User;

import java.util.List;

public interface UserService {

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUserById(Long id);

    public User getUserById(Long id);

    public List<User> allUsers();

}

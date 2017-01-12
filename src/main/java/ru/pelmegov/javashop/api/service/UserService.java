package ru.pelmegov.javashop.api.service;

import ru.pelmegov.javashop.model.User;

import java.util.Set;

public interface UserService {

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUserById(Long id);

    public User getUserById(Long id);

    public Set<User> allUsers();

}

package ru.pelmegov.javashop.api.service;

import ru.pelmegov.javashop.model.User;

import java.util.List;

public interface UserService {

    public boolean addUser(User user);

    public boolean updateUser(User user);

    public boolean removeUser(Long id);

    public User getUserById(Long id);

    public List<User> listUsers();

}

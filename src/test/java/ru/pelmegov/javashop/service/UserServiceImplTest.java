package ru.pelmegov.javashop.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.pelmegov.javashop.api.service.RoleService;
import ru.pelmegov.javashop.api.service.UserService;
import ru.pelmegov.javashop.config.AppConfig;
import ru.pelmegov.javashop.model.Role;
import ru.pelmegov.javashop.model.User;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
@ExtendWith(SpringExtension.class)
@DisplayName("UserService")
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    // user id
    private static int id = 0;

    @Test
    @DisplayName("Add user")
    void addUser() {
        User user = generateTestUser();
        userService.addUser(user);
        User newUser = userService.getUserByLogin(user.getLogin());
        assertEquals(user.getLogin(), newUser.getLogin());
        assertEquals(user.getPassword(), newUser.getPassword());
        assertEquals(user.getRoles(), newUser.getRoles());
    }

    @Test
    @DisplayName("Update user")
    void updateUser() {
        User user = generateTestUser();

        String newLogin = "new_login";
        String newPassword = "new_password";

        user.setLogin(newLogin);
        user.setPassword(newPassword);
        userService.updateUser(user);

        User newUser = userService.getUserByLogin(user.getLogin());
        assertEquals(newLogin, newUser.getLogin());
        assertEquals(newPassword, newUser.getPassword());
    }

    @Test
    @DisplayName("Delete user by id")
    void deleteUserById() {
        User user = generateTestUser();
        Integer id = user.getId();
        userService.deleteUserById(id);

        assertNull(userService.getUserById(id));
    }

    @Test
    @DisplayName("Get user by id")
    void getUserById() {
        User user = generateTestUser();
        Integer id = user.getId();
        userService.addUser(user);

        assertNotNull(userService.getUserById(id));
    }

    @Test
    @DisplayName("Get user by login")
    void getUserByLogin() {
        User user = generateTestUser();
        String login = user.getLogin();
        userService.addUser(user);

        assertNotNull(userService.getUserByLogin(login));
    }

    @Test
    @DisplayName("Get all users")
    void getAllUsers() {
        userService.addUser(generateTestUser());
        assertNotNull(userService.getAllUsers());
    }

    private User generateTestUser() {
        User user = new User();
        user.setId(++id);
        Set<Role> roleSet = roleService.getAllRoles();
        user.setLogin("tester" + id);
        user.setPassword("tester" + id);
        user.setRoles(roleSet);
        return user;
    }
}

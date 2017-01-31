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
import ru.pelmegov.javashop.model.user.Role;
import ru.pelmegov.javashop.model.user.User;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
@ExtendWith(SpringExtension.class)
@DisplayName("RoleService")
public class RoleServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    // user id
    private static int id = 0;

    @Test
    @DisplayName("getRoleByName")
    void getRoleByNameTest(){
        User user = generateTestUser();
        userService.addUser(user);
        //get role from user by roleService
        Role role2 = roleService.getRoleByName(user.getLogin());
        assertEquals(user.getRoles(), role2);

    }

    @Test
    @DisplayName("getRoleById")
    void getRoleByIdTest(){
        User user = generateTestUser();
        userService.addUser(user);

        //get role from user by roleService
        Role role3 = roleService.getRoleById(user.getId());
        assertEquals(user.getRoles(), role3);
    }

    @Test
    @DisplayName("getAllRoles")
    void getAllRolesTest(){
        assertNotNull(roleService.getAllRoles());
    }

    private User generateTestUser(){
        Role role = new Role();
        role.setName("test");
        Set<Role> roleset = new HashSet<>();
        roleset.add(role);

        User user = new User();
        user.setId(++id);
        user.setLogin("test" + id);
        user.setPassword("test" + id);
        user.setRoles(roleset);
        return user;
    }
}

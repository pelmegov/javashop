package ru.pelmegov.javashop.service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ru.pelmegov.javashop.api.service.UserService;
import ru.pelmegov.javashop.config.*;
import ru.pelmegov.javashop.config.security.SecurityConfig;
import ru.pelmegov.javashop.config.security.SecurityInit;
import ru.pelmegov.javashop.model.Role;
import ru.pelmegov.javashop.model.User;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class, AppInit.class, SecurityConfig.class, SecurityInit.class, ThymeleafConfig.class, UserServiceImpl.class, UserService.class})
public class UserServiceImplTest extends AbstractTransactionalJUnit4SpringContextTests{

    @Autowired
    public UserServiceImpl userServiceImpl;

    public UserServiceImplTest() {
    }

    @org.junit.Test
    public void addUserTest() {
        User testForAddUser = generateTestUser();
        userServiceImpl.addUser(testForAddUser);
        User user = userServiceImpl.getUserByLogin(testForAddUser.getLogin());
        assertEquals(testForAddUser.getLogin(), user.getLogin());
        assertEquals(testForAddUser.getPassword(), user.getPassword());
        assertEquals(testForAddUser.getRoles(),user.getRoles());
    }

    @org.junit.Test
    public  void updateUserTest(){

        User testUser = new User();
        testUser.setLogin("New_login");
        testUser.setPassword("New_pass");
//        testUser.setRoles();
        userServiceImpl.updateUser(testUser);
        userServiceImpl.getUserByLogin(testUser.getLogin());
        assertEquals("New_login", testUser.getLogin());
        assertEquals("New_pass", testUser.getPassword());
    }

    private User generateTestUser() {
        User testUser = new User();
        Set<Role> roleSet = new HashSet<Role>();
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        roleSet.add(role);
        testUser.setLogin("test");
        testUser.setPassword("test");
        testUser.setRoles(roleSet);
        return testUser;
    }
}

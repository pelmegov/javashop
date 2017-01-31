package ru.pelmegov.javashop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.pelmegov.javashop.api.service.RoleService;
import ru.pelmegov.javashop.api.service.UserService;
import ru.pelmegov.javashop.model.user.Role;
import ru.pelmegov.javashop.model.user.User;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
public class SecurityController {

    private String loginView = "/login";
    private String registrationView = "/registration";
    private String error403View = "/403";

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public SecurityController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {
        ModelAndView model = new ModelAndView(loginView);
        if (error != null) {
            model.addObject("error", "Invalid Login Or Password!");
        }
        return model;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration(User user, @RequestParam(value = "error", required = false) String error) {
        ModelAndView model = new ModelAndView(registrationView);
        if (error != null) {
            model.addObject("error", "Invalid Login Or Password!");
        }
        return model;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registration(@Valid @ModelAttribute User user,
                                     final BindingResult result,
                                     final ModelAndView modelAndView) {
        if (result.hasErrors()) {
            modelAndView.addObject("error", "Invalid Login Or Password!");
            return modelAndView;
        }
        // ToDO Реализовать. Попытка добавить пользователя с существующим логином
        if (userService.getUserByLogin(user.getLogin()) != null) {
            modelAndView.addObject("error", "User with this login exists!");
            return modelAndView;
        }
        Set<Role> role = new HashSet<>();
        role.add(roleService.getRoleByName("ROLE_USER"));
        user.setRoles(role);
        user.setActive(true);
        userService.addUser(user);
        return new ModelAndView(loginView);
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accessDenied() {
        ModelAndView model = new ModelAndView(error403View);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            model.addObject("username", userDetail.getUsername());
        }
        return model;
    }

}

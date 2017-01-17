package ru.pelmegov.javashop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.pelmegov.javashop.api.service.RoleService;
import ru.pelmegov.javashop.api.service.UserService;
import ru.pelmegov.javashop.model.Role;
import ru.pelmegov.javashop.model.User;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("user/index");
        modelAndView.addObject("users", userService.allUsers());
        return modelAndView;
    }

    @RequestMapping(value = {"/addUser"}, method = RequestMethod.GET)
    public ModelAndView addUser(User user) {
        ModelAndView modelAndView = new ModelAndView("user/addUser");
        modelAndView.addObject("roles", roleService.allRoles());
        return getUserModelAndView(modelAndView, user);
    }

    @RequestMapping(value = {"/addUser"}, method = RequestMethod.POST)
    public ModelAndView addUser(@Valid @ModelAttribute final User user,
                                final BindingResult result,
                                ModelAndView modelAndView,
                                RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            return getUserModelAndView(modelAndView, user);
        }

        Role user_role = roleService.getRoleByName("ROLE_USER");
        user.setRole(user_role);
        userService.addUser(user);
        redirectAttrs.addFlashAttribute("success", "User added: " + user);

        return new ModelAndView("redirect:/user/index");
    }

    @RequestMapping(value = {"/updateUser/{id}", "/updateUser"}, method = RequestMethod.GET)
    public ModelAndView updateUser(User user, RedirectAttributes redirectAttrs) {
        ModelAndView modelAndView = new ModelAndView("user/updateUser");

        if (user.getId() == null) {
            redirectAttrs.addFlashAttribute("error", "Not the selected user");
            return new ModelAndView("redirect:/user/index");
        }

        user = userService.getUserById(user.getId());

        modelAndView.addObject("roles", roleService.allRoles());
        modelAndView.addObject("user", user);
        return getUserModelAndView(modelAndView, user);
    }

    @RequestMapping(value = {"/updateUser"}, method = RequestMethod.POST)
    public ModelAndView updateUser(@Valid @ModelAttribute User user,
                                   @RequestParam(value = "roles", required = false) Long[] roles,
                                   final BindingResult result,
                                   final ModelAndView modelAndView,
                                   RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            return getUserModelAndView(modelAndView, user);
        }

        Set<Role> setRoles = new HashSet<Role>();
        if (roles != null)
            for (Long role : roles) {
                setRoles.add(roleService.getRoleById(role));
            }
        user.setRoles(setRoles);
        userService.updateUser(user);
        redirectAttrs.addFlashAttribute("success", "User updated: " + user);

        return new ModelAndView("redirect:/user/index");
    }

    private ModelAndView getUserModelAndView(ModelAndView modelAndView, User user) {
        modelAndView.addObject("currentRoles", user.getRoles());
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = {"/deleteUser/{id}"}, method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") Long id, RedirectAttributes redirectAttrs) {
        userService.deleteUserById(id);
        redirectAttrs.addFlashAttribute("success", "Delete user with id: " + id);

        return "redirect:/user/";
    }
}

package ru.pelmegov.javashop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.pelmegov.javashop.api.service.UserService;
import ru.pelmegov.javashop.model.User;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
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
        modelAndView.addObject("user", user);
        return getUserModelAndView(modelAndView, user);
    }

    @RequestMapping(value = {"/updateUser"}, method = RequestMethod.POST)
    public ModelAndView updateUser(@Valid @ModelAttribute final User user,
                                   final BindingResult result,
                                   final ModelAndView modelAndView,
                                   RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            return getUserModelAndView(modelAndView, user);
        }
        userService.updateUser(user);
        redirectAttrs.addFlashAttribute("success", "User updated: " + user);

        return new ModelAndView("redirect:/user/index");
    }

    private ModelAndView getUserModelAndView(ModelAndView modelAndView, User user) {
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

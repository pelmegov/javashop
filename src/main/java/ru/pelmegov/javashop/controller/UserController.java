package ru.pelmegov.javashop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
        modelAndView.addObject("users", userService.listUsers());
        return modelAndView;
    }

    @RequestMapping(value = {"/addUser"}, method = RequestMethod.GET)
    public ModelAndView addUser() {
        ModelAndView modelAndView = new ModelAndView("user/addUser");
        return modelAndView;
    }

    @RequestMapping(value = {"/addUser"}, method = RequestMethod.POST)
    public String addUser(@Valid final User user,
                          final BindingResult result,
                          RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            redirectAttrs.addFlashAttribute("error", "Error! Invalid field.");
            return "redirect:/user/addUser";
        }
        userService.addUser(user);
        redirectAttrs.addFlashAttribute("success", "Add user. Name.");

        return "redirect:/user/";
    }

    @RequestMapping(value = {"/updateUser/{id}"}, method = RequestMethod.GET)
    public ModelAndView updateUser(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("user/updateUser");
        User user = userService.getUserById(id);
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = {"/updateUser"}, method = RequestMethod.POST)
    public String updateUser(@Valid final User user,
                             final BindingResult result,
                             RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            redirectAttrs.addFlashAttribute("error", "Error! Invalid fields.");
            return "redirect:/user/updateUser/" + user.getId();
        }
        userService.updateUser(user);
        redirectAttrs.addFlashAttribute("success", "Update name.");

        return "redirect:/user/";
    }

    @RequestMapping(value = {"/delUser/{id}"}, method = RequestMethod.GET)
    public String delUser(@PathVariable("id") Long id, RedirectAttributes redirectAttrs) {
        userService.removeUser(id);
        redirectAttrs.addFlashAttribute("success", "Delete user with id = " + id);

        return "redirect:/user/";
    }

}

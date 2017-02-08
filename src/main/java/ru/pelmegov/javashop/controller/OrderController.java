package ru.pelmegov.javashop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.pelmegov.javashop.model.order.Status;
import ru.pelmegov.javashop.service.CartService;
import ru.pelmegov.javashop.service.MailService;
import ru.pelmegov.javashop.service.OrderService;
import ru.pelmegov.javashop.service.UserService;
import ru.pelmegov.javashop.model.cart.Cart;
import ru.pelmegov.javashop.model.order.Order;
import ru.pelmegov.javashop.model.user.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
public class OrderController {

    private String ordersView = "/order/index";

    private final UserService userService;
    private final OrderService orderService;
    private final CartService cartService;
    private final MailService mailService;

    @Autowired
    public OrderController(UserService userService, OrderService orderService,
                           CartService cartService, MailService mailService) {
        this.userService = userService;
        this.orderService = orderService;
        this.cartService = cartService;
        this.mailService = mailService;
    }

    @RequestMapping(value = {"/order"}, method = RequestMethod.GET)
    public ModelAndView getOrders() {
        ModelAndView modelAndView = new ModelAndView(ordersView);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userService.getUserByLogin(userName);

        List<Order> orders = new ArrayList<>(user.getOrders());
        orders.sort(Comparator.comparing(Order::getId).reversed());
        modelAndView.addObject("orders", orders);
        return modelAndView;
    }

    @RequestMapping(value = {"/order/create"}, method = RequestMethod.GET)
    public ModelAndView createOrder() {
        ModelAndView modelAndView = new ModelAndView(ordersView);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userService.getUserByLogin(userName);

        if (user.getCart().getItems().isEmpty()) {
            return modelAndView;
        }

        Cart oldCart = user.getCart();
        user.setCart(new Cart());

        Order order = new Order();
        order.setCart(oldCart);
        order.setUser(user);

        order.setStatus(Status.WAIT);
        user.addOrder(order);

        cartService.updateCart(oldCart);
        orderService.addOrder(order);
        userService.updateUser(user);

        // send email for user
        mailService.sendEmail(order);

        List<Order> orders = new ArrayList<>(user.getOrders());
        orders.sort(Comparator.comparing(Order::getId).reversed());
        modelAndView.addObject("orders", orders);
        return modelAndView;
    }
}

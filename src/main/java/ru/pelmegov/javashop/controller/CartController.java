package ru.pelmegov.javashop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.pelmegov.javashop.api.service.CartService;
import ru.pelmegov.javashop.api.service.GoodService;
import ru.pelmegov.javashop.api.service.UserService;
import ru.pelmegov.javashop.model.cart.Cart;
import ru.pelmegov.javashop.model.cart.Item;
import ru.pelmegov.javashop.model.good.Good;
import ru.pelmegov.javashop.model.user.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Controller
public class CartController {

    private String cartView = "/cart/index";

    private final GoodService goodService;
    private final UserService userService;
    private final CartService cartService;

    @Autowired
    public CartController(GoodService goodService, UserService userService, CartService cartService) {
        this.goodService = goodService;
        this.userService = userService;
        this.cartService = cartService;
    }

    @RequestMapping(value = {"/cart"}, method = RequestMethod.GET)
    public ModelAndView cart() {
        ModelAndView modelAndView = new ModelAndView(cartView);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();

        User user = userService.getUserByLogin(userName);
        modelAndView.addObject("items", user.getCart().getItems());
        modelAndView.addObject("cart", user.getCart());

        return modelAndView;
    }

    @RequestMapping(value = {"/cart/delete/{id}"}, method = RequestMethod.GET)
    public ModelAndView deleteItem(@PathVariable(value = "id") Integer id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();

        User user = userService.getUserByLogin(userName);
        Cart cart = user.getCart();
        Item item = cart.getItem(id);

        Double itemsSum = item.getGood().getPrice() * item.getCount();
        cart.setSum(cart.getSum() - itemsSum);

        if (cart.getItems().remove(item))
            cartService.updateCart(cart);

        return cart();
    }

    @ResponseBody
    @RequestMapping(value = {"/cart/calculate"})
    public String cartCalculate(@RequestBody Map<String, String> json) {

        Integer id = Integer.valueOf(json.get("id"));
        Boolean isPlus = Boolean.valueOf(json.get("isPlus"));

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();

        User user = userService.getUserByLogin(userName);
        Cart cart = user.getCart();
        Item item = cart.getItem(id);

        if (isPlus) {
            item.setCount(item.getCount() + 1);
            cart.setSum(cart.getSum() + item.getGood().getPrice());
        } else {
            if (item.getCount() > 1) {
                item.setCount(item.getCount() - 1);
                cart.setSum(cart.getSum() - item.getGood().getPrice());
            }
        }
        cartService.updateCart(cart);

        Map<String, Object> objects = new HashMap<>();
        objects.put("count", item.getCount());
        objects.put("sum", cart.getSum());

        return getJson(objects);
    }

    @ResponseBody
    @RequestMapping(value = {"/cart/buy"})
    public String buyGood(@RequestBody String id) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();

        User user = userService.getUserByLogin(userName);
        Good good = goodService.getGoodById(Integer.valueOf(id), true);

        Cart cart = user.getCart();
        addItemInCart(good, cart);
        cartService.updateCart(cart);

        return getJson("<b>" + good.getTitle() + "</b> been successfully added in your cart!");
    }

    /**
     * Метод для преобразования Java объекта в JavaScript объект или строку
     *
     * @param object Java объект для преобразования
     * @return результат в виде JavaScript объекта или строки
     */
    private String getJson(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        String result = null;
        try {
            result = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Метод добавляет Item в корзину
     *
     * @param good товар, для которого нужно создать Item корзины
     * @param cart корзина, в которой будет содержаться Item
     */
    private void addItemInCart(Good good, Cart cart) {
        Set<Item> items = cart.getItems();
        boolean flag = true;
        for (Item item : items) {
            if (item.getGood().equals(good)) {
                item.setCount(item.getCount() + 1);
                cart.setSum(cart.getSum() + good.getPrice());
                flag = false;
            }
        }
        if (flag) {
            Item newItem = new Item();
            newItem.setGood(good);
            newItem.setCart(cart);
            newItem.setCount(1);
            cart.setSum(cart.getSum() + good.getPrice());
            cart.addItem(newItem);
        }
    }
}

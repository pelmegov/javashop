package ru.pelmegov.javashop.dao;

import ru.pelmegov.javashop.model.order.Order;

import java.util.Set;

public interface OrderDAO {

    public void addOrder(Order order);

    public void updateOrder(Order order);

    public Order getOrderById(Integer id);

    public Set<Order> getAllOrders();
}

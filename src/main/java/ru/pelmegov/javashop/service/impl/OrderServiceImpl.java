package ru.pelmegov.javashop.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pelmegov.javashop.dao.OrderDAO;
import ru.pelmegov.javashop.service.OrderService;
import ru.pelmegov.javashop.model.order.Order;

import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO;

    public OrderServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    @Transactional
    public void addOrder(Order order) {
        this.orderDAO.addOrder(order);
    }

    @Override
    @Transactional
    public void updateOrder(Order order) {
        orderDAO.updateOrder(order);
    }

    @Override
    @Transactional
    public Order getOrderById(Integer id) {
        return orderDAO.getOrderById(id);
    }

    @Override
    @Transactional
    public Set<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }
}

package ru.pelmegov.javashop.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pelmegov.javashop.dao.OrderDAO;
import ru.pelmegov.javashop.service.OrderService;
import ru.pelmegov.javashop.model.order.Order;

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
}

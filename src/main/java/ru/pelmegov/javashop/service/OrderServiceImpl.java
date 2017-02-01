package ru.pelmegov.javashop.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pelmegov.javashop.api.dao.OrderDAO;
import ru.pelmegov.javashop.api.service.OrderService;
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
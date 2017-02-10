package ru.pelmegov.javashop.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import ru.pelmegov.javashop.dao.OrderDAO;
import ru.pelmegov.javashop.model.order.Order;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class OrderDAOImpl extends AbstractDAO implements OrderDAO {

    public OrderDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public void addOrder(Order order) {
        getSession().saveOrUpdate(order);
    }

    @Override
    public void updateOrder(Order order) {
        getSession().update(order);
    }

    @Override
    public Order getOrderById(Integer id) {
        Order order = (Order) getSession().createCriteria(Order.class).add(Restrictions.eq("id", id)).uniqueResult();
        return order;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<Order> getAllOrders() {
        List<Order> orders = getSession().createCriteria(Order.class).addOrder(org.hibernate.criterion.Order.asc("id")).list();
        return new HashSet<>(orders);
    }
}

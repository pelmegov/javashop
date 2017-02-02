package ru.pelmegov.javashop.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.pelmegov.javashop.api.dao.OrderDAO;
import ru.pelmegov.javashop.model.order.Order;

@Repository
public class OrderDAOImpl extends AbstractDAO implements OrderDAO {

    public OrderDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public void addOrder(Order order) {
        getSession().saveOrUpdate(order);
    }
}

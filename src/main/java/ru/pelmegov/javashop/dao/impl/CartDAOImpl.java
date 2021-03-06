package ru.pelmegov.javashop.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.pelmegov.javashop.dao.CartDAO;
import ru.pelmegov.javashop.model.cart.Cart;

@Repository
public class CartDAOImpl extends AbstractDAO implements CartDAO {

    public CartDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public void updateCart(Cart cart) {
        getSession().update(cart);
    }
}

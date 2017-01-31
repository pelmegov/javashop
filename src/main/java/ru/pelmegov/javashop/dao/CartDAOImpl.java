package ru.pelmegov.javashop.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.pelmegov.javashop.api.dao.CartDAO;
import ru.pelmegov.javashop.model.cart.Cart;
import ru.pelmegov.javashop.model.cart.Item;

@Repository
public class CartDAOImpl extends AbstractDAO implements CartDAO {

    public CartDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public void updateCart(Cart cart) {
        if (cart.getItems().size() > 0) {
            for (Item item : cart.getItems())
                getSession().saveOrUpdate(item);
        }
        getSession().update(cart);
    }

}

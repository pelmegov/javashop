package ru.pelmegov.javashop.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import ru.pelmegov.javashop.api.dao.GoodDAO;
import ru.pelmegov.javashop.model.Good;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class GoodDAOImpl extends AbstractDAO implements GoodDAO {

    public GoodDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Good getGoodByName(String name) {
        return (Good) getSession().createCriteria(Good.class).add(Restrictions.eq("name", name)).uniqueResult();
    }

    @Override
    public Good getGoodById(Long id) {
        return (Good) getSession().createCriteria(Good.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<Good> allGoods() {
        List<Good> goods = getSession().createCriteria(Good.class).list();
        return new HashSet<Good>(goods);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<Good> getLastAddedGoods(Integer col) {
        List<Good> goods = getSession()
                .createCriteria(Good.class)
                .addOrder(Order.desc("id"))
                .setMaxResults(col)
                .list();
        return new HashSet<Good>(goods);
    }
}

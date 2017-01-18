package ru.pelmegov.javashop.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.pelmegov.javashop.api.dao.GoodDAO;
import ru.pelmegov.javashop.model.Good;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Repository
public class GoodDAOImpl extends AbstractDAO implements GoodDAO {

    public GoodDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Good getGoodByName(String goodName) {
        return (Good) getSession().createQuery("FROM Good WHERE name = :name").setParameter("name", goodName).uniqueResult();
    }

    @Override
    public Good getGoodById(Long id) {
        return (Good) getSession().createQuery("FROM Good WHERE id = :id").setParameter("id", id).uniqueResult();
    }

    @Override
    public Set<Good> allGoods() {
        List<Good> goods = getSession().createQuery("FROM Good").list();
        return new HashSet<Good>(goods);
    }

    @Override
    public Set<Good> getLastAddedGoods(Integer col) {
        List<Good> goods = getSession().createQuery("FROM Good ORDER BY id DESC").setMaxResults(col).list();
        return new HashSet<Good>(goods);
    }
}

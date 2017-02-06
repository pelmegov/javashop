package ru.pelmegov.javashop.dao.impl;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import ru.pelmegov.javashop.dao.GoodDAO;
import ru.pelmegov.javashop.model.good.Good;

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
        return (Good) getSession()
                .createCriteria(Good.class)
                .add(Restrictions.eq("name", name))
                .uniqueResult();
    }

    @Override
    public Good getGoodByName(String name, Boolean active) {
        return (Good) getSession()
                .createCriteria(Good.class)
                .add(Restrictions.eq("name", name))
                .add(Restrictions.eq("active", active))
                .uniqueResult();
    }

    @Override
    public Good getGoodById(Integer id) {
        return (Good) getSession()
                .createCriteria(Good.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public Good getGoodById(Integer id, Boolean active) {
        return (Good) getSession()
                .createCriteria(Good.class)
                .add(Restrictions.eq("id", id))
                .add(Restrictions.eq("active", active))
                .uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<Good> getAllGoods() {
        List<Good> goods = getSession()
                .createCriteria(Good.class)
                .list();
        return new HashSet<>(goods);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<Good> getAllGoods(Boolean active) {
        List<Good> goods = getSession()
                .createCriteria(Good.class)
                .add(Restrictions.eq("active", active))
                .list();
        return new HashSet<>(goods);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<Good> getGoodsByCategory(Integer categoryId) {
        return getGoodsByCategory(null, categoryId);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<Good> getGoodsByCategory(Integer count, Integer categoryId) {
        List<Good> goods;

        if (count != null) {
            goods = getSession()
                    .createCriteria(Good.class)
                    .add(Restrictions.eq("category.id", categoryId))
                    .setMaxResults(count)
                    .list();
        } else {
            goods = getSession()
                    .createCriteria(Good.class)
                    .add(Restrictions.eq("category.id", categoryId))
                    .list();
        }
        return new HashSet<>(goods);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<Good> getGoodsByCategory(Integer categoryId, Boolean active) {
        return getGoodsByCategory(null, categoryId, active);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<Good> getGoodsByCategory(Integer count, Integer categoryId, Boolean active) {
        List<Good> goods;

        if (count != null) {
            goods = getSession()
                    .createCriteria(Good.class)
                    .add(Restrictions.eq("category.id", categoryId))
                    .add(Restrictions.eq("active", active))
                    .setMaxResults(count)
                    .list();
        } else {
            goods = getSession()
                    .createCriteria(Good.class)
                    .add(Restrictions.eq("category.id", categoryId))
                    .add(Restrictions.eq("active", active))
                    .list();
        }
        return new HashSet<>(goods);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<Good> getGoods(Integer count) {
        List<Good> goods = getSession()
                .createCriteria(Good.class)
                .setMaxResults(count)
                .list();
        return new HashSet<>(goods);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<Good> getGoods(Integer count, Boolean active) {
        List<Good> goods = getSession()
                .createCriteria(Good.class)
                .add(Restrictions.eq("active", active))
                .setMaxResults(count)
                .list();
        return new HashSet<>(goods);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<Good> getLastAddedGoods(Integer count) {
        List<Good> goods = getSession()
                .createCriteria(Good.class)
                .addOrder(Order.desc("id"))
                .setMaxResults(count)
                .list();
        return new HashSet<>(goods);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<Good> getLastAddedGoods(Integer count, Boolean active) {
        List<Good> goods = getSession()
                .createCriteria(Good.class)
                .add(Restrictions.eq("active", active))
                .addOrder(Order.desc("id"))
                .setMaxResults(count)
                .list();
        return new HashSet<>(goods);
    }
}

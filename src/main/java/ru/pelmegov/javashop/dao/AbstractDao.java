package ru.pelmegov.javashop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public AbstractDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}

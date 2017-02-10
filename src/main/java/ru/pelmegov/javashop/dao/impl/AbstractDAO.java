package ru.pelmegov.javashop.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public AbstractDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}

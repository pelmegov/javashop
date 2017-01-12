package ru.pelmegov.javashop.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.pelmegov.javashop.api.dao.RoleDAO;
import ru.pelmegov.javashop.model.Role;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RoleDAOImpl extends AbstractDAO implements RoleDAO {

    public RoleDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return (Role) getSession().createQuery("FROM Role WHERE name = :name").setParameter("name", roleName).uniqueResult();
    }

    @Override
    public Role getRoleById(Long id) {
        return (Role) getSession().createQuery("FROM Role WHERE id = :id").setParameter("id", id).uniqueResult();
    }

    @Override
    public Set<Role> allRoles() {
        List<Role> roles = getSession().createQuery("FROM Role").list();
        return new HashSet<Role>(roles);
    }
}

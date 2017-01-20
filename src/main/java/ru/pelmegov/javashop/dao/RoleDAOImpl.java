package ru.pelmegov.javashop.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
    public Role getRoleByName(String name) {
        return (Role) getSession().createCriteria(Role.class).add(Restrictions.eq("name", name)).uniqueResult();
    }

    @Override
    public Role getRoleById(Integer id) {
        return (Role) getSession().createCriteria(Role.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<Role> getAllRoles() {
        List<Role> roles = getSession().createCriteria(Role.class).list();
        return new HashSet<Role>(roles);
    }
}

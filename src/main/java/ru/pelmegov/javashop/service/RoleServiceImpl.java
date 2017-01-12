package ru.pelmegov.javashop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pelmegov.javashop.api.dao.RoleDAO;
import ru.pelmegov.javashop.api.service.RoleService;
import ru.pelmegov.javashop.model.Role;

import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDAO roleDao;

    @Autowired
    public RoleServiceImpl(RoleDAO roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    @Transactional
    public Role getRoleByName(String roleName) {
        return roleDao.getRoleByName(roleName);
    }

    @Override
    @Transactional
    public Role getRoleById(Long id) {
        return roleDao.getRoleById(id);
    }

    @Override
    @Transactional
    public Set<Role> allRoles() {
        return roleDao.allRoles();
    }
}

package ru.pelmegov.javashop.dao;

import ru.pelmegov.javashop.model.user.Role;

import java.util.Set;

public interface RoleDAO {

    public Role getRoleByName(String name);

    public Role getRoleById(Integer id);

    public Set<Role> getAllRoles();
}

package ru.pelmegov.javashop.api.dao;

import ru.pelmegov.javashop.model.Role;

import java.util.Set;

public interface RoleDAO {

    public Role getRoleByName(String roleName);

    public Role getRoleById(Long id);

    public Set<Role> allRoles();

}

package ru.pelmegov.javashop.api.service;

import ru.pelmegov.javashop.model.user.Role;

import java.util.Set;

public interface RoleService {

    public Role getRoleByName(String name);

    public Role getRoleById(Integer id);

    public Set<Role> getAllRoles();
}

package ru.pelmegov.javashop.api.service;

import ru.pelmegov.javashop.model.Role;

import java.util.Set;

public interface RoleService {

    public Role getRoleByName(String name);

    public Role getRoleById(Long id);

    public Set<Role> allRoles();

}

package ru.pelmegov.javashop.formatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pelmegov.javashop.api.service.RoleService;
import ru.pelmegov.javashop.model.Role;
import org.springframework.format.Formatter;
import java.text.ParseException;
import java.util.Locale;

@Component
public class RoleFormatter implements Formatter<Role> {

    @Autowired
    RoleService roleService;

    @Override
    public Role parse(String id, Locale locale) throws ParseException {
        return roleService.getRoleById(Long.valueOf(id));
    }

    @Override
    public String print(Role role, Locale locale) {
        return String.valueOf(role.getId());
    }
}

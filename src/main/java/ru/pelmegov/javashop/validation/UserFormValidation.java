package ru.pelmegov.javashop.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.pelmegov.javashop.model.user.User;

@Component
public class UserFormValidation implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        if (user.getLogin().length() < 3 || user.getLogin().length() > 32) {
            errors.rejectValue("login", "incorrectSize");
        }
        if (user.getPassword().length() < 6 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "incorrectSize");
        }
    }
}

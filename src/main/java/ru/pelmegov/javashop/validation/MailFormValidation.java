package ru.pelmegov.javashop.validation;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component("emailValidator")
@Data
public class MailFormValidation {

    private Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public MailFormValidation() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    public boolean valid(final String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}

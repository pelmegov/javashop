package ru.pelmegov.javashop.formatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import ru.pelmegov.javashop.model.good.Category;
import ru.pelmegov.javashop.model.user.Role;
import ru.pelmegov.javashop.service.CategoryService;

import java.text.ParseException;
import java.util.Locale;

@Component
public class CategoryFormatter implements Formatter<Category> {

    private final CategoryService categoryService;

    @Autowired
    public CategoryFormatter(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public Category parse(String id, Locale locale) throws ParseException {
        return categoryService.getCategoryById(Integer.valueOf(id));
    }

    @Override
    public String print(Category category, Locale locale) {
        return String.valueOf(category.getId());
    }
}

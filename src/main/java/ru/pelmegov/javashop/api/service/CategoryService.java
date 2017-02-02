package ru.pelmegov.javashop.api.service;

import ru.pelmegov.javashop.model.good.Category;

public interface CategoryService {
    Category getCategoryById(Integer id);

    void addCategory(Category category);

    void updateCategory(Category category);

    void deleteCategoryById(Integer id);
}

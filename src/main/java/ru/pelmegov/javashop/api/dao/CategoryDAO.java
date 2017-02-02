package ru.pelmegov.javashop.api.dao;

import ru.pelmegov.javashop.model.good.Category;

public interface CategoryDAO {
    Category getCategoryById(Integer id);

    void updateCategory(Category category);

    void addCategory(Category category);

    void deleteCategoryById(Integer id);
}

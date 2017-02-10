package ru.pelmegov.javashop.dao;

import ru.pelmegov.javashop.model.good.Category;

import java.util.Set;

public interface CategoryDAO {

    Category getCategoryById(Integer id);

    void updateCategory(Category category);

    void addCategory(Category category);

    void deleteCategoryById(Integer id);

    Set<Category> getAllCategory();
}

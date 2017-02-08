package ru.pelmegov.javashop.service;

import ru.pelmegov.javashop.model.good.Category;

import java.util.Set;

public interface CategoryService {

    Category getCategoryById(Integer id);

    void addCategory(Category category);

    void updateCategory(Category category);

    void deleteCategoryById(Integer id);

    Set<Category> getAllCategory();
}

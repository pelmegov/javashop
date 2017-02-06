package ru.pelmegov.javashop.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pelmegov.javashop.dao.CategoryDAO;
import ru.pelmegov.javashop.service.CategoryService;
import ru.pelmegov.javashop.model.good.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private  final CategoryDAO categoryDAO;

    public CategoryServiceImpl(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Override
    public void addCategory(Category category) {
        this.categoryDAO.addCategory(category);
    }

    @Override
    public void updateCategory(Category category) {
        this.categoryDAO.updateCategory(category);
    }

    @Override
    public Category getCategoryById(Integer id) {
        return this.categoryDAO.getCategoryById(id);
    }

    @Override
    public void deleteCategoryById(Integer id) {
        this.categoryDAO.deleteCategoryById(id);
    }
}

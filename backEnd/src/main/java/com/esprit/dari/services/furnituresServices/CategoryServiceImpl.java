package com.esprit.dari.services.furnituresServices;

import com.esprit.dari.dao.furnituresRepository.CategoryRepository;
import com.esprit.dari.entities.furnituresEntities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService{

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Long ajouterCategory(Category category) {
        categoryRepository.save(category);
        return category.getCategoryId();
    }

    @Override
    public void deleteCategoryById(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    @Override
    public List<Category> getAllCategory() {
        return (List<Category>) categoryRepository.findAll();
    }
}

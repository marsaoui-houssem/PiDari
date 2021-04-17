package com.esprit.dari.services.furnituresServices;

import com.esprit.dari.entities.furnituresEntities.Category;

import java.util.List;

public interface ICategoryService {

    public Long ajouterCategory(Category category);
    public void deleteCategoryById(Long categoryId);
    public List<Category> getAllCategory();

}

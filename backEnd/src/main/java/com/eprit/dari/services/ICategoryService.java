package com.eprit.dari.services;

import com.eprit.dari.entities.Category;

import java.util.List;

public interface ICategoryService {

    public Long ajouterCategory(Category category);
    public void deleteCategoryById(Long categoryId);
    public List<Category> getAllCategory();

}

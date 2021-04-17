package com.eprit.dari.services;

import com.eprit.dari.entities.Category;
import com.eprit.dari.entities.Furniture;

import java.util.List;

public interface IFurnitureService {

    public Long ajouterFurniture(Furniture furniture);
    public void deleteFurnitureById(Long furnitureId);
    public List<Furniture> getAllFurniture();
}

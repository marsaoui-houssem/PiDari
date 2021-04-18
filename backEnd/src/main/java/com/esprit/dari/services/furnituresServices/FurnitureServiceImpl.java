package com.esprit.dari.services.furnituresServices;

import com.esprit.dari.dao.furnituresRepository.FurnitureRepository;
import com.esprit.dari.entities.furnituresEntities.Furniture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FurnitureServiceImpl implements IFurnitureService{

    @Autowired
    FurnitureRepository furnitureRepository;

    @Override
    public Long ajouterFurniture(Furniture furniture) {
        furnitureRepository.save(furniture);
        return furniture.getFurnitureId();
    }

    @Override
    public void deleteFurnitureById(Long furnitureId) {
        furnitureRepository.deleteById(furnitureId);

    }

    @Override
    public List<Furniture> getAllFurniture() {
        return (List<Furniture>) furnitureRepository.findAll();

    }
}

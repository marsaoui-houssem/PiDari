package com.eprit.dari.services;

import com.eprit.dari.entities.Basket;
import com.eprit.dari.entities.Category;

import java.util.List;

public interface IBasketService {

    public Long ajouterBasket(int quantity, Long userDariId, Long furnitureId);
    public void deleteBasketById(Long basketId);
    public List<Basket> getAllBasket();
    public Boolean verifierFournitureInBasket(Long furnitureId , Long userDariId);
}

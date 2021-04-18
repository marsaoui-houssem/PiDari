package com.esprit.dari.services.furnituresServices;

import com.esprit.dari.entities.furnituresEntities.Basket;

import java.util.List;

public interface IBasketService {

    public Long ajouterBasket(int quantity, Long userDariId, Long furnitureId);
    public void deleteBasketById(Long basketId);
    public List<Basket> getAllBasket();
    public Boolean verifierFournitureInBasket(Long furnitureId , Long userDariId);
}

package com.eprit.dari.services;

import com.eprit.dari.entities.Category;
import com.eprit.dari.entities.Livraison;

import java.util.List;

public interface ILivraisonService {
    public void addLivraionPrice(Float livraisonPrice);
    public void deleteLivraionPriceById(Long livraisonId);
    public List<Livraison> getAllLivraionPrice();
}

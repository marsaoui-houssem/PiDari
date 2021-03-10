package com.esprit.dari.services;

import com.esprit.dari.entities.Abonnement;

import java.util.List;

public interface IAbonnementService {

     public int ajoutAbonn (Abonnement abon);
    public List<Abonnement> getAllAbon();
    public Abonnement getByIdAbonn (int id );
    public void deleteAbonn(int id );
}

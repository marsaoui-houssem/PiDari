package com.esprit.dari.services;

import com.esprit.dari.entities.Abonnement;
import com.esprit.dari.entities.Assurence;
import com.esprit.dari.entities.OffreService;

import java.util.List;

public interface IAbonnementService {

     public int ajoutAbonn (Abonnement abon);
    public List<Abonnement> getAllAbon();
    public Abonnement getByIdAbonn (int id );
    public void deleteAbonn(int id );
    public List<Assurence> getAllAssubyAbon (int idAbon );
    public List<OffreService> getAllServbyAbon (int idAbon) ;
}

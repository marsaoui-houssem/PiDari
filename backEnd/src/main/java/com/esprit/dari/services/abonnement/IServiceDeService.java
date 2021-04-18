package com.esprit.dari.services.abonnement;

import com.esprit.dari.entities.abonnement.OffreService;

import java.util.List;

public interface IServiceDeService {

    public int  ajoutService( OffreService serv);
    public List<OffreService> getAllService();
    public OffreService getByIdService (int id );
    public void deleteService(int id);
    public void affecteServiceAabonn ( int idServ  , int idAbon );
    public float prixServiceMenagement (int idServ  , Long idAd    );
    public void mettreAjourPrixService( int idServ , Long idAd );
}

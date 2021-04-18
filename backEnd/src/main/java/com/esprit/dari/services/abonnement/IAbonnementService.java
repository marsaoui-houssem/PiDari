package com.esprit.dari.services.abonnement;

import com.esprit.dari.entities.AdAppointment.Ad;
import com.esprit.dari.entities.abonnement.Abonnement;

import com.esprit.dari.entities.abonnement.Assurence;
import com.esprit.dari.entities.abonnement.OffreService;

import java.util.Date;
import java.util.List;

public interface IAbonnementService {

     public int ajoutAbonn (Abonnement abon);
    public List<Abonnement> getAllAbon();
    public Abonnement getByIdAbonn (int id );
    public void deleteAbonn(int id );
    public void affecteruserAabon (Long userId , int idAbon );
    public List<Assurence> getAllAssubyAbon (int idAbon );
    public List<OffreService> getAllServbyAbon (int idAbon) ;
    public List<Date> getAllDatefint ();
    public  float  prixAbonRemise (int id );
    public void mettreAjourPrixRemise( int id );
    public  String conseilleAchatAbon( Long userId);
    public List<Ad> getAllAdByuser(Long userId);
    public void mettreAjourdatefinByAbon(Date datefint , int idAbon );
    public String CaracteristiqueAbonne (int idAbon);
    public void alerFintAbonnement ();
    public int countAbonserver ();
    public int countAbonGold();
    public int ContAbonPremium();
    public String meilleurVenteAbon();
}

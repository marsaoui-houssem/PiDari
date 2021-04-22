package com.esprit.dari.services.abonnement;

import com.esprit.dari.entities.abonnement.Assurence;

import java.util.List;

public interface IAssurenceService   {
    public int ajoutAssurence (Assurence asur);
    public List<Assurence> getAllAssurence();
    public Assurence getByIdAssurence (int id );
    public void deleteAssurence(int id );
    public void affecteAssurAbonn ( int idAssu  ,  int idAbon);
    public void desaffecterAssurenceDuAbon( int idAssu );
    public float PrixAssurenceMulti (int idAssu , int idAd );
    public void mettreAjourPrixAssurenceMulti (int idAssu , int idAd  );
    public float PrixAssurenceMultiLoyerImp (int idAssu ,  int idAd);
    public void mettreAjourPrixAssurenceMultiLoyerImp (int idAssu ,  int idAd);



}

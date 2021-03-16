package com.esprit.dari.services;

import com.esprit.dari.entities.Abonnement;
import com.esprit.dari.entities.Assurence;

import java.util.List;

public interface IAssurenceService   {
    public int ajoutAssurence (Assurence asur);
    public List<Assurence> getAllAssurence();
    public Assurence getByIdAssurence (int id );
    public void deleteAssurence(int id );
    public void affecteAssurAbonn ( int idAssu  ,  int idAbon);


}

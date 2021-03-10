package com.esprit.dari.services;

import com.esprit.dari.dao.IAbonnementRepository;
import com.esprit.dari.entities.Abonnement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class AbonnementServiceImpl implements IAbonnementService {

    @Autowired
    IAbonnementRepository abonRep;


    @Override
    public int ajoutAbonn(Abonnement abon) {
        abonRep.save(abon);
        return abon.getIdAbon();
    }

    @Override
    public List<Abonnement> getAllAbon() {

        return (List<Abonnement>) abonRep.findAll();
    }


    @Override
    public Abonnement getByIdAbonn(int id) {
        return abonRep.findById(id).get();
    }


    @Override
    public void deleteAbonn(int id) {
        Abonnement abonn = abonRep.findById(id).orElse(null);
        abonRep.delete(abonn);


    }
}
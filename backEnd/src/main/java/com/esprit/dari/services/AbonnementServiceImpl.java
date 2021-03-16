package com.esprit.dari.services;

import com.esprit.dari.dao.IAbonnementRepository;
import com.esprit.dari.dao.IAssurenceRepository;
import com.esprit.dari.dao.IServiceRepository;
import com.esprit.dari.entities.Abonnement;
import com.esprit.dari.entities.Assurence;
import com.esprit.dari.entities.OffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class AbonnementServiceImpl implements IAbonnementService {

    @Autowired
    IAbonnementRepository abonRep;

    @Autowired
    IAssurenceRepository assRep ;

    @Autowired
    IServiceRepository servRep ;


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
    @Override
    public List<Assurence> getAllAssubyAbon (int idAbon ){ return  assRep.getAllAssubyAbon(idAbon);
    }
    @Override
    public List<OffreService> getAllServbyAbon (int idAbon){
        return servRep.getAllServbyAbon(idAbon);
    }

}
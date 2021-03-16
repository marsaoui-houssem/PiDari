package com.esprit.dari.services;


import com.esprit.dari.dao.IAbonnementRepository;
import com.esprit.dari.dao.IAssurenceRepository;
import com.esprit.dari.entities.Abonnement;
import com.esprit.dari.entities.Assurence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AssurenceServiceImpl implements IAssurenceService {


    @Autowired
    IAssurenceRepository assRep ;


    @Autowired
    IAbonnementRepository abonRep ;


    @Override
    public int ajoutAssurence (Assurence asur){
        assRep.save(asur);
        return asur.getIdAssu() ;
    }

    @Override
    public List<Assurence> getAllAssurence(){

        return (List<Assurence>)  assRep.findAll();
    }


    @Override
    public Assurence getByIdAssurence (int id ){
        return assRep.findById(id).get();
    }


    @Override
    public void deleteAssurence(int id ){
        Assurence assu = assRep.findById(id).orElse(null);
        assRep.delete(assu);


    }

     @Override
     public void affecteAssurAbonn ( int idAssu  ,  int idAbon){

        Assurence ass = assRep.findById(idAssu).get();
        Abonnement abon = abonRep.findById(idAbon).get();

        if (abon.getAssurences() == null ){

            List<Assurence> assuren = new ArrayList<>();
            assuren.add(ass);
            abon.setAssurences(assuren);
            abonRep.save(abon);
        }
        else {
            abon.getAssurences().add(ass);
            abonRep.save(abon);
        }





    }






}

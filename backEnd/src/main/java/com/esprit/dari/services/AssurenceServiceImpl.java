package com.esprit.dari.services;


import com.esprit.dari.dao.IAbonnementRepository;
import com.esprit.dari.dao.IAssurenceRepository;
import com.esprit.dari.entities.Abonnement;
import com.esprit.dari.entities.Assurence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     public void affecteAssurAbonn (int idAbon, int idAssu  ){

      Assurence as =  assRep.findById(idAssu).orElse(null);
      Abonnement ab = abonRep.findById(idAbon).orElse(null);

         as.setAbonnement(ab);
         assRep.save(as);

    }






}

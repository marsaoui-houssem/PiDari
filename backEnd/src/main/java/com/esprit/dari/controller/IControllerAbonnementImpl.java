package com.esprit.dari.controller;


import com.esprit.dari.entities.Abonnement;
import com.esprit.dari.services.IAbonnementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class IControllerAbonnementImpl {

     @Autowired
     IAbonnementService abonserv ;

     private List<Abonnement> listabons ;





    public int ajoutAbonn (Abonnement abon){
         abonserv.ajoutAbonn(abon);
        return abon.getIdAbon();
    }

    public List<Abonnement> getAllAbon(){
        listabons = abonserv.getAllAbon();
        return  listabons ;
    }


    public Abonnement getByIdAbonn (int id ){

        return abonserv.getByIdAbonn(id);
    }


    public void deleteAbonn(int id  ){
        abonserv.deleteAbonn(id);
    }


      ///////////////////////////////////////


    public List<Abonnement> getListabons() {
        return listabons;
    }

    public void setListabons(List<Abonnement> listabons) {
        this.listabons = listabons;
    }
}

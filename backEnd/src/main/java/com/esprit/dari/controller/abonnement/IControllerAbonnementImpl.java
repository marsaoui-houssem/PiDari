package com.esprit.dari.controller.abonnement;


import com.esprit.dari.entities.abonnement.Abonnement;
import com.esprit.dari.entities.abonnement.Assurence;
import com.esprit.dari.services.abonnement.IAbonnementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;
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


    public void affecteruserAabon (Long userId , int idAbon ){ abonserv.affecteruserAabon(userId,idAbon); }

    public List<Assurence> getAllAssubyAbon (int idAbon ){
        return abonserv.getAllAssubyAbon(idAbon);
    }



    public List<Date> getAllDatefint(){return abonserv.getAllDatefint(); }



    public void mettreAjourdatefinByAbon(Date datefint , int idAbon ){
        abonserv.mettreAjourdatefinByAbon(datefint, idAbon);
    }

    public String CaracteristiqueAbonne (int idAbon ){
        return abonserv.CaracteristiqueAbonne(idAbon) ;
    }


    public void alerFintAbonnement (){
        abonserv.alerFintAbonnement();
    }

    public  float  prixAbonRemise (int id){
        return abonserv.prixAbonRemise(id);
    }

    public void mettreAjourPrixRemise( int id ){abonserv.mettreAjourPrixRemise(id); }

    public  String conseilleAchatAbon( Long userId) { return abonserv.conseilleAchatAbon(userId) ;  }


    public String meilleurVenteAbon(){ return abonserv.meilleurVenteAbon();  }



      ///////////////////////////////////////


    public List<Abonnement> getListabons() {
        return listabons;
    }

    public void setListabons(List<Abonnement> listabons) {
        this.listabons = listabons;
    }
}

package com.esprit.dari.controller.abonnement;

import com.esprit.dari.entities.AdAppointment.Ad;
import com.esprit.dari.entities.abonnement.Abonnement;

import com.esprit.dari.entities.abonnement.Assurence;
import com.esprit.dari.entities.abonnement.OffreService;
import com.esprit.dari.services.abonnement.IAbonnementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("Abonnement")
public class RestControllerAbonnement {

     @Autowired
    IAbonnementService abonserv ;




     @GetMapping(value = "/getAllAbon")
     @ResponseBody
    public List<Abonnement> getAllAbon(){
        return  abonserv.getAllAbon();

    }


    @GetMapping(value = "/getAbonnById/{id}")
    @ResponseBody
     public  Abonnement getByIdAbonn(@PathVariable("id") int id ){
         return abonserv.getByIdAbonn(id );
     }



    @PostMapping(value="/ajouterAbonn")
    @ResponseBody
    public int ajoutAbonn(@RequestBody  Abonnement Abon) {

        abonserv.ajoutAbonn(Abon);
        return Abon.getIdAbon();

    }

    @PutMapping(value = "/affecteruserAabon/{userId}/{idAbon}")
    public void affecteruserAabon (@PathVariable("userId") Long userId ,@PathVariable("idAbon") int idAbon ){
         abonserv.affecteruserAabon(userId , idAbon);
    }


    @DeleteMapping(value="/deleteAbon/{id}")
    @ResponseBody
    public void deleteAbonn(@PathVariable("id") int id  ){
      abonserv.deleteAbonn(id);
    }


    @GetMapping(value = "/getAllAssubyAbon/{idAbon}")
    @ResponseBody
    public List<Assurence> getAllAssubyAbon (@PathVariable("idAbon")   int idAbon ){
       return  abonserv.getAllAssubyAbon(idAbon);
    }

    @GetMapping(value = "/getAllServbyAbon/{idAbon}")
    @ResponseBody
    public List<OffreService> getAllServbyAbon (@PathVariable("idAbon")   int idAbon ){
        return  abonserv.getAllServbyAbon(idAbon);
    }


    @GetMapping(value="/getAllDatefint")
    @ResponseBody
    public List<Date> getAllDatefint (){
         return abonserv.getAllDatefint();
    }


    @PutMapping(value ="/mettreAjourdatefinByAbon/{datefint}/{idAbon}")
    @ResponseBody
    public void mettreAjourdatefinByAbon(@PathVariable("datefint") Date datefint ,@PathVariable("idAbon") int idAbon )
    { abonserv.mettreAjourdatefinByAbon(datefint,idAbon); }


    @GetMapping(value="/CaracteristiqueAbonne/{idAbon}")
     @ResponseBody
    public String CaracteristiqueAbonne (@PathVariable("idAbon") int idAbon ){
         return abonserv.CaracteristiqueAbonne( idAbon);
    }


    @GetMapping(value = "/alerFintAbonnement")
    @ResponseBody
    public void alerFintAbonnement (){
         abonserv.alerFintAbonnement();
    }




    @GetMapping(value="/prixAbonRemise/{idAbon}")
    @ResponseBody
    public  float  prixAbonRemise (@PathVariable("idAbon") int id){
         return abonserv.prixAbonRemise(id);
    }


    @PutMapping(value = "mettreAjourPrixRemise/{idAbon}" )
    @ResponseBody
    public void mettreAjourPrixRemise(@PathVariable("idAbon") int id ){ abonserv.mettreAjourPrixRemise(id); }


    @GetMapping(value ="getAllAdByuser/{userId}" )
    @ResponseBody
    public List<Ad> getAllAdByuser(@PathVariable("userId") Long userId){
         return abonserv.getAllAdByuser(userId);
    }




    @GetMapping(value = "/conseilleAchatAbon/{userId}")
    @ResponseBody
    public  String conseilleAchatAbon(@PathVariable("userId") Long userId){
         return abonserv.conseilleAchatAbon(userId);
    }



    @GetMapping(value = "/meilleurVenteAbon")
     @ResponseBody
    public String meilleurVenteAbon(){
         return abonserv.meilleurVenteAbon();
    }


}

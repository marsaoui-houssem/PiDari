package com.esprit.dari.controller.abonnement;


import com.esprit.dari.entities.abonnement.Assurence;
import com.esprit.dari.services.abonnement.IAssurenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Assurence")
public class RestControllerAssurence {


      @Autowired
    IAssurenceService assuServ ;



    @GetMapping(value = "/getAllassu")
    @ResponseBody
    public List<Assurence> getAllAssurence(){
        return  assuServ.getAllAssurence();

    }


    @GetMapping(value = "/getAssuById/{id}")
    @ResponseBody
    public  Assurence getByIdAssurence(@PathVariable("id") int id ){
        return assuServ.getByIdAssurence(id);
    }



    @PostMapping(value="/ajouterAssu")
    @ResponseBody
    public int ajoutAssurence(@RequestBody  Assurence Assu) {

        assuServ.ajoutAssurence(Assu);
        return Assu.getIdAssu();

    }

    @DeleteMapping(value="/deleteAssu/{id}")
    @ResponseBody
    public void deleteAssurence(@PathVariable("id") int id  ){
        assuServ.deleteAssurence(id);
    }


     @PutMapping(value = "/affAssAbonn/{idAssu}/{idAbon}")
     @ResponseBody
    public void affecteAssurAbonn (@PathVariable("idAssu") int idAssu ,@PathVariable("idAbon") int idAbon ){
        assuServ.affecteAssurAbonn(idAssu , idAbon);
   }

    @PutMapping(value = "/desaffecterAssurenceDuAbon/{idAssu}")
    @ResponseBody
    public void desaffecterAssurenceDuAbon(@PathVariable("idAssu") int idAssu ){
        assuServ.desaffecterAssurenceDuAbon(idAssu);
    }
     @GetMapping(value="/PrixAssurenceMulti/{idAssu}/{idAd}")
     @ResponseBody
    public float PrixAssurenceMulti (@PathVariable("idAssu") int idAssu ,@PathVariable("idAd") int idAd  ){

        return assuServ.PrixAssurenceMulti(idAssu, idAd);
    }

    @ResponseBody
    @PutMapping(value = "/mettreAjourPrixAssuMulti/{idAssu}/{idAd}")
    public void mettreAjourPrixAssurenceMulti (@PathVariable("idAssu") int idAssu ,@PathVariable("idAd") int idAd ){

        assuServ.mettreAjourPrixAssurenceMulti(idAssu,idAd);
    }

    @GetMapping(value="/PrixAssurenceMultiLoyerImp/{idAssu}/{idAd}")
    @ResponseBody
    public float PrixAssurenceMultiLoyerImp (@PathVariable("idAssu") int idAssu ,@PathVariable("idAd")  int idAd){

        return assuServ.PrixAssurenceMultiLoyerImp(idAssu,idAd);   }

   @ResponseBody
   @PutMapping(value = "/mettreAjourPrixAssuloyerImp/{idAssu}/{idAd}")
    public void mettreAjourPrixAssurenceMultiLoyerImp (@PathVariable("idAssu")  int idAssu ,@PathVariable("idAd") int idAd){

        assuServ.mettreAjourPrixAssurenceMultiLoyerImp(idAssu,idAd);
    }

}

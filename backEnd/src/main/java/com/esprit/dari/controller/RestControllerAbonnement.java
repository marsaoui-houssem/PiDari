package com.esprit.dari.controller;

import com.esprit.dari.entities.Abonnement;
import com.esprit.dari.services.IAbonnementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
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

    @DeleteMapping(value="/deleteAbon/{id}")
    @ResponseBody
    public void deleteAbonn(@PathVariable("id") int id  ){
      abonserv.deleteAbonn(id);
    }


}

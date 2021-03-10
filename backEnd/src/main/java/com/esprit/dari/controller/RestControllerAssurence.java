package com.esprit.dari.controller;


import com.esprit.dari.entities.Abonnement;
import com.esprit.dari.entities.Assurence;
import com.esprit.dari.services.IAbonnementService;
import com.esprit.dari.services.IAssurenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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


     @PutMapping("/affAssAbonn/{idAbon}/{idAssu}")
     public void affecteAssurAbonn (@PathVariable("idAbon") int idAbon,@PathVariable("idAssu") int idAssu  ){
        assuServ.affecteAssurAbonn(idAbon,idAssu);
    }

}

package com.esprit.dari.controller;


import com.esprit.dari.entities.Assurence;
import com.esprit.dari.entities.OffreService;
import com.esprit.dari.services.IServiceDeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class RestControllerService {



    @Autowired
    IServiceDeService serserv ;


    @PostMapping(value="/ajouterService")
    @ResponseBody
    public int  ajoutService(@RequestBody OffreService serv){
        serserv.ajoutService(serv);

        return serv.getIdServ();
    }



    @GetMapping(value = "/getAllServ")
    @ResponseBody
    public List<OffreService> getAllService(){
       return serserv.getAllService();
    }




    @GetMapping(value = "/getServById/{id}")
    @ResponseBody
    public OffreService getByIdService (@PathVariable("id") int id )
    {
        return serserv.getByIdService(id);
    }


    @DeleteMapping(value="/deleteServ/{id}")
    @ResponseBody
    public void deleteService(@PathVariable("id") int id ){
        serserv.deleteService(id);}


   @PutMapping("/affServAbonn/{idServ}/{idAbon}")
    public void affecteServiceAabonn (@PathVariable("idServ") int idServ  ,@PathVariable("idAbon") int idAbon ){
        serserv.affecteServiceAabonn(idServ, idAbon);

    }







}

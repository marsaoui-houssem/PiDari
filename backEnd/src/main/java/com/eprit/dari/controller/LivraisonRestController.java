package com.eprit.dari.controller;

import com.eprit.dari.entities.Livraison;
import com.eprit.dari.services.ILivraisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LivraisonRestController {

    @Autowired
    ILivraisonService iLivraisonService;


    @PostMapping("/livraisonPrice/{livraisonPrice}")
    @ResponseBody
    public void updateLivraisonPrice(@PathVariable("livraisonPrice") Float livraisonPrice){
        iLivraisonService.addLivraionPrice(livraisonPrice);
    }
    @GetMapping(value = "/getAllLivraison")
    @ResponseBody
    public List<Livraison> findAllLivraison(){
        return iLivraisonService.getAllLivraionPrice();
    }


    @DeleteMapping("/deletelivraisonPrice/{livraisonPriceId}")
    @ResponseBody
    public void deleteLivraison(@PathVariable("livraisonPriceId") Long livraisonPriceId){
        iLivraisonService.deleteLivraionPriceById(livraisonPriceId);
    }
}

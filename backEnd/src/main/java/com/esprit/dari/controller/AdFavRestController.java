package com.esprit.dari.controller;

import com.esprit.dari.dao.AdFavRepository;
import com.esprit.dari.dao.AdRepository;
import com.esprit.dari.entities.Ad;
import com.esprit.dari.entities.AdFav;
//import com.esprit.dari.services.interfaces.AdFavService;
import com.esprit.dari.services.interfaces.AdFavService;
import com.esprit.dari.services.interfaces.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class AdFavRestController {
    @Autowired
    private AdFavRepository AdfavRepository;

    // URL : http://localhost:3300/dari/Ad
    @GetMapping ("/AdFav")
    @ResponseBody
    public List<AdFav> AdsFavList(){
        return AdfavRepository.findAll();

    }
    @Autowired
    AdFavService EstService;
    @PostMapping ("/AdFav")
    @ResponseBody
   public AdFav save(@RequestBody AdFav adFav){
       return AdfavRepository.save(adFav);
    }

    @PostMapping("/addFavEstate")
    public int AddEstate(@RequestParam("idest") Long EstId, @RequestParam("iduser") Long userId){

EstService.AddEstateFav(EstId,userId);
        return 1;
    }

    //@GetMapping("/getEstate")
    //public List<AdFav> getEst(){
       // return EstService.loadNotVerifiedEstate();
    //}

    @PutMapping("/deleteFavEstate")
    public int Delete(@RequestParam("id") Long adId){

        EstService.DeleteEstateFav(adId);
        return 1000;


    }



}

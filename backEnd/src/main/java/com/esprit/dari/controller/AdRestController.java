package com.esprit.dari.controller;

import com.esprit.dari.dao.AdRepository;
import com.esprit.dari.entities.AdType;
import com.esprit.dari.services.AdServiceImpl;
import com.esprit.dari.services.interfaces.AdService;
import com.esprit.dari.entities.Ad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class AdRestController {
    @Autowired
    private AdRepository AdsRepository;

    // URL : http://localhost:3300/dari/Ad
    @GetMapping ("/Ad")
    @ResponseBody
    public List<Ad> AdsList(){
        return AdsRepository.findAll();

    }
    @PostMapping ("/Ad")
    @ResponseBody
   public Ad save(@RequestBody Ad ad){
       return AdsRepository.save(ad);
    }

    @Autowired
    AdService EstService;
    @PostMapping("/addEstate")
    public Ad AddEstate(@RequestBody Ad Est,@RequestParam("id") Long userId){

       EstService.AddEstate(Est,userId);
        return Est;
    }

    @GetMapping("/getEstate")
    public List<Ad> getEst(){
        return EstService.loadAllAds();
    }
    @PutMapping("/updateEstate")
    public Ad Update(@RequestBody Ad Est,@RequestParam("id") Long adId)
    {

        EstService.Update(Est,adId);
       return Est;
    }
    @PutMapping("/deleteEstate")
  public int Delete(@RequestParam("id") Long adId){

        EstService.DeleteEstate(adId);
        return 1000;


  }
    @GetMapping("/getEstatebyregion")
    public List<Ad> getEsttype(@RequestParam("region") String region){
        return EstService.loadAdByRegion(region);
    }
}

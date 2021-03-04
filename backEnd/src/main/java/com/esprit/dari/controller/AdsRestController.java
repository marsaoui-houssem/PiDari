package com.esprit.dari.controller;

import com.esprit.dari.dao.AdsRepository;
import com.esprit.dari.dao.TaskRepository;
import com.esprit.dari.entities.Ads;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdsRestController {
    @Autowired
    private AdsRepository AdsRepository;

    // URL : http://localhost:8081/dari/Ads
    @GetMapping ("/Ads")
    @ResponseBody
    public List<Ads> AdsList(){
        return AdsRepository.findAll();

    }
    @PostMapping ("/Ads")
    @ResponseBody
    public Ads save(@RequestBody Ads ad){
        return AdsRepository.save(ad);
    }


}

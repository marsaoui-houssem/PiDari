package com.esprit.dari.controller.AdAppointmentController;

import com.esprit.dari.dao.AdAppointmentRepository.AdFavRepository;
import com.esprit.dari.entities.AdAppointment.AdFav;
//import com.esprit.dari.services.interfaces.AdFavService;
import com.esprit.dari.services.AdAppointmentService.interfaces.AdFavService;
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
    public int AddEstate(@RequestParam("idest") int EstId, @RequestParam("iduser") Long userId){

EstService.AddEstateFav(EstId,userId);
        return 1;
    }

    //@GetMapping("/getEstate")
    //public List<AdFav> getEst(){
       // return EstService.loadNotVerifiedEstate();
    //}

    @PutMapping("/deleteFavEstate")
    public int Delete(@RequestParam("id") long adId){

        EstService.DeleteEstateFav(adId);
        return 1000;


    }



}

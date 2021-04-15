package com.esprit.dari.services.AdAppointmentService;

import com.esprit.dari.entities.AdAppointment.AdType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.dari.entities.AdAppointment.Ad;
import com.esprit.dari.dao.AdAppointmentRepository.AdRepository;
import com.esprit.dari.dao.UserDariRepository;
import com.esprit.dari.services.AdAppointmentService.interfaces.AdService;

import java.util.List;
//import tn.dari.spring.service.interfaces.PriceHistoryService;

@Service
public class AdServiceImpl implements AdService {

    @Autowired
    AdRepository estRep;
    @Autowired
    UserDariRepository userRep;
    //@Autowired
   // PriceHistoryService announcementService;


    @Override
    public void Update( Ad estate, Long estateId) {

        Ad ann = estRep.findById(estateId).get();



        estate.setUser(ann.getUser());

        estate.setIdAd(estateId);
        estRep.save(estate);

    }

    @Override
    public Long AddEstate(Ad estate, Long userId) {

        estate.setUser(userRep.findByUserId(userId));

        estRep.save(estate);


        return estate.getIdAd();

    }

    @Override
    public void DeleteEstate(Long id) {


            estRep.deleteById(id);


    }

    @Override
    public int countEstate() {
        return 0;
    }

    @Override
    public List<Ad> loadAdByEstateType(AdType estateType) {
        return estRep.findByType(estateType);

    }

    @Override
    public List<Ad> loadAdByRegion(String region) {
        return (List<Ad>)estRep.findByRegion(region);
    }

    @Override
    public List<Ad> loadAdByPrice(double price) {
        return estRep.findByPrice(price);
    }

    @Override
    public List<Ad> loadAdBySurface(double surface) {
        return estRep.findBySurface(surface);
    }

    @Override
    public List<Ad> loadAdByRooms(int rooms) {
        return estRep.findByRooms(rooms);
    }

    @Override
    public List<Ad> loadAllAds() {

        return (List<Ad>) estRep.findAll();

    }


}

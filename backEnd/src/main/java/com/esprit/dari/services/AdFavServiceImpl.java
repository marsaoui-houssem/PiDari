package com.esprit.dari.services;

import com.esprit.dari.dao.AdFavRepository;
import com.esprit.dari.dao.AdRepository;
import com.esprit.dari.dao.UserDariRepository;
import com.esprit.dari.entities.AdFav;
import com.esprit.dari.entities.Ad;
import com.esprit.dari.entities.UserDari;
import com.esprit.dari.services.interfaces.AdFavService;
import com.esprit.dari.services.interfaces.AdFavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//import tn.dari.spring.service.interfaces.PriceHistoryService;

@Service
public class AdFavServiceImpl implements AdFavService {

    @Autowired
    AdRepository estRep;
    @Autowired
    AdFavRepository estFavRep;
    @Autowired
    UserDariRepository userRep;





    @Override
    public Long AddEstateFav(Long estateId, Long userId) {

AdFav f = new AdFav();
        UserDari user = userRep.findById(userId).get();
        Ad a = estRep.findById(estateId).get();

        if (a == null)
            throw new RuntimeException("Announcement not found");
        if (user == null)
            throw new RuntimeException("user not found");


            f.setUser(user);
            f.setAds(a);

            estFavRep.save(f);

       return f.getIdFav();

    }

    @Override
    public void DeleteEstateFav(Long id) {


            estFavRep.deleteById(id);


    }

}
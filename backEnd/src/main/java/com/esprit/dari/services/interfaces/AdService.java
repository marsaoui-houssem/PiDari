package com.esprit.dari.services.interfaces;

import java.util.List;
import com.esprit.dari.entities.Ad;
import com.esprit.dari.entities.AdType;


public interface AdService {

    public void Update(Ad estate,Long estateId);
    public Long AddEstate(Ad estate,Long userId);
    public void DeleteEstate(Long id);
    public int countEstate();
    public List<Ad> loadAdByEstateType(AdType estateType);
    public List<Ad> loadAdByRegion(String region);
    public List<Ad> loadAdByPrice(double price);
    public List<Ad> loadAdBySurface(double surface);
    public List<Ad> loadAdByRooms(int rooms);
    public List<Ad> loadAllAds();


}

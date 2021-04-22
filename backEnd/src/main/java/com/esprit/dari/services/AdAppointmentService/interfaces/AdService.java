package com.esprit.dari.services.AdAppointmentService.interfaces;

import java.util.List;
import com.esprit.dari.entities.AdAppointment.Ad;
import com.esprit.dari.entities.AdAppointment.AdType;


public interface AdService {

    public void Update(Ad estate,int estateId);
    public int AddEstate(Ad estate,long userId);
    public void DeleteEstate(int id);
    public int countEstate();
    public List<Ad> loadAdByEstateType(AdType estateType);
    public List<Ad> loadAdByRegion(String region);
    public List<Ad> loadAdByPrice(double price);
    public List<Ad> loadAdBySurface(double surface);
    public List<Ad> loadAdByRooms(int rooms);
    public List<Ad> loadAllAds();


}

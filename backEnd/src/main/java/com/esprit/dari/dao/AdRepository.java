package com.esprit.dari.dao;


import com.esprit.dari.entities.Ad;
import com.esprit.dari.entities.AdType;
import com.esprit.dari.entities.UserDari;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AdRepository extends JpaRepository<Ad,Long> {

       //public List<Ad> findByEstateType(String estateType);
       public Ad findByidAd(Long id);
    public List<Ad> findByRegion(String region);
  public List<Ad> findByPrice(double price);
    public List<Ad> findBySurface(double surface);
    public List<Ad> findByRooms(int rooms);
    public List<Ad> findByRoomsGreaterThan(int rooms);
    public List<Ad> findByRoomsLessThan(int rooms);
   public List<Ad> findByType(AdType type);
   // public List<Ad> findByNumberOfFloors(int etage);
  //  public List<Ad> findByNumberOfFloorsGreaterThan(int etage);
   // public List<Ad> findByNumberOfFloorsLessThan(int etage);


}

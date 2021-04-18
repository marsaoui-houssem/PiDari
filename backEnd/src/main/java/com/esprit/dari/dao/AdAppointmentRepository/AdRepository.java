package com.esprit.dari.dao.AdAppointmentRepository;


import com.esprit.dari.entities.AdAppointment.Ad;
import com.esprit.dari.entities.AdAppointment.AdType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AdRepository extends JpaRepository<Ad,Long> {

       //public List<Ad> findByEstateType(String estateType);
    // a voir // public Ad findByidAd(Long id);
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



    @Query(value ="select * from ad ad , user_dari userr  where userr.user_id=:userId and userr.user_id = ad.user_dari_user_id",nativeQuery = true)
    public List<Ad> getAllAdByuser (@Param("userId") Long userId);


}

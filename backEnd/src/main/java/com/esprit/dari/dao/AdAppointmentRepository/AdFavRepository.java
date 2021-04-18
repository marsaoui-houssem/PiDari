package com.esprit.dari.dao.AdAppointmentRepository;


import com.esprit.dari.entities.AdAppointment.AdFav;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdFavRepository extends JpaRepository<AdFav,Long> {

    //   public List<Ad> findByEstateType(String estateType);
   // public List<Ad> findByLocation(String location);
   // public List<Ad> findByPrice(double price);
   // public List<Ad> findBySurface(double surface);
   // public List<Ad> findByNumberOfRooms(int numberOfRooms);
   // public List<Ad> findByNumberOfRoomsGreaterThan(int numberOfRooms);
   // public List<Ad> findByNumberOfRoomsLessThan(int numberOfRooms);
   //public List<Ad> findByVerifiedTrue();
    //public List<Ad> findByVerifiedFalse();
   // public List<Ad> findByType(AdType announcementType);
   // public List<Ad> findByNumberOfFloors(int etage);
  //  public List<Ad> findByNumberOfFloorsGreaterThan(int etage);
   // public List<Ad> findByNumberOfFloorsLessThan(int etage);


}

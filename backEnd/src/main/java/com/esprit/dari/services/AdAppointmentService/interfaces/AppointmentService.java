package com.esprit.dari.services.AdAppointmentService.interfaces;

import com.esprit.dari.entities.AdAppointment.Appointment;


public interface AppointmentService {

    public void UpdateApp(Appointment app,Long AppointmentId);
    public Long AddAppointment(Appointment app,Long userId,Long adId );
    public void DeleteAppointment(Long id);
   // public int countEstate();
   // public List<Ad> loadAdByEstateType(String estateType);
   // public List<Ad> loadAdByLocation(String location);
   // public List<Ad> loadAdByPrice(double price);
   // public List<Ad> loadAdBySurface(double surface);
   // public List<Ad> loadAdByNumberOfRooms(int numberOfRooms);
   // public List<Ad> loadAllAds();
   // public List<Ad> loadVerifiedEstate();
   // public List<Ad> loadNotVerifiedEstate();

}

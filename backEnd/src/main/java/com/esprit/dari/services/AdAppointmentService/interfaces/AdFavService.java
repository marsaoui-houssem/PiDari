package com.esprit.dari.services.AdAppointmentService.interfaces;


public interface AdFavService {

    //public void UpdateFav(AdFav estate,Long estateId);
    public Long AddEstateFav(Long estateId,Long userId);
    public void DeleteEstateFav(Long id);
   // public int countEstate();


}

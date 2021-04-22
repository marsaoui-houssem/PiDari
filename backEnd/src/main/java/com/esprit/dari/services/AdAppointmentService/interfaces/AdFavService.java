package com.esprit.dari.services.AdAppointmentService.interfaces;


public interface AdFavService {

    //public void UpdateFav(AdFav estate,Long estateId);
    public Long AddEstateFav(int estateId,Long userId);
    public void DeleteEstateFav(long id);
   // public int countEstate();


}

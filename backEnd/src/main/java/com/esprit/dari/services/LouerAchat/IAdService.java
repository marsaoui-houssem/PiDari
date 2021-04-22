package com.esprit.dari.services.LouerAchat;

import java.util.List;

import com.esprit.dari.entities.AdAppointment.Ad;
import com.esprit.dari.entities.AdAppointment.Ad_Etat;
import com.esprit.dari.entities.LouerAchat.AdCriteria;
import com.esprit.dari.entities.LouerAchat.AdEstimation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


public interface IAdService {

	public Ad AddAd(Ad ad, Long User_id);
	public void UpdateAdd(int adId);
	public void DeleteAdById(int adId);
	public List<Ad> findAllAds();
	public Ad findById(int Adid);
	public void affecterUsertoAd(int AdId,Long UserId);
	public List<Ad> GetBestReductions();
	//public List<Ad> GetAllAdsByEtat(Ad_Etat Etat);
	public List<Ad> findByCriteria(AdCriteria AdC) ;
	public float findEstimation(AdEstimation AdE);
    public List<Ad> SearchBytitle(String Text);

}

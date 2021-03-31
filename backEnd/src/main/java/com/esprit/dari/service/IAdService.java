package com.esprit.dari.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.entities.AdCriteria;
import tn.esprit.spring.entities.AdEstimation;
import tn.esprit.spring.entities.Ad_Etat;

public interface IAdService {

	public Ad AddAd(Ad ad);
	public void UpdateAdd(int adId);
	public void DeleteAdById(int adId);
	public List<Ad> findAllAds();
	public Ad findById(int Adid);
	public void affecterUsertoAd(int AdId,int UserId);
	public List<Ad> GetBestReductions();
	public List<Ad> GetAllAdsByEtat(Ad_Etat Etat);
	public List<Ad> findByCriteria(AdCriteria AdC) ;
	public float findEstimation(AdEstimation AdE);
    public List<Ad> SearchBytitle(String Text);

}

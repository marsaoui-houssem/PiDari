package com.esprit.dari.services.LouerAchat;

import java.util.Date;
import java.util.List;

import com.esprit.dari.entities.AdAppointment.Ad;
import com.esprit.dari.entities.LouerAchat.rent;
import org.springframework.web.bind.annotation.PathVariable;



public interface IRentAdService {

	public rent AddAd(rent R);
	
	/*
	public void UpdateRent(int RentId);
*/
	public void Addrent(Date datedebut,Date datefin,int idAd,Long idUser);
	public List<Ad> findAdsRentedByUser(int UserId);
	public List<rent> findAllRentAds();
	public rent findRentById(int RentId);
	public void DeleteRentAdById(int RentId);
	public float Calculate_Price(int AdId,Date date_debut,Date date_fin,String choice);

}


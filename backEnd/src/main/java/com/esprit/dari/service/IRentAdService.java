package com.esprit.dari.service;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.entities.rent;

public interface IRentAdService {

	public rent AddAd(rent R);
	
	/*
	public void UpdateRent(int RentId);

*/
	public void Addrent(Date datedebut,Date datefin,int idAd,int idUser);
	public List<Ad> findAdsRentedByUser(int UserId);
	public List<rent> findAllRentAds();
	public rent findRentById(int RentId);
	public void DeleteRentAdById(int RentId);
	public float Calculate_Price(int AdId,Date date_debut,Date date_fin,String choice);
	
}


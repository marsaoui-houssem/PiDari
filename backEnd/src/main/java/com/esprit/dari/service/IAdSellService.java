package com.esprit.dari.service;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.entities.Sell;
import tn.esprit.spring.entities.rent;

public interface IAdSellService {

	public void AddBid(int idAd,int idUser,int Price);
	public Sell AddSellAd(Sell S);
	public void DeleteSellAd(int i);
}

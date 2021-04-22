package com.esprit.dari.services.LouerAchat;

import java.util.Date;
import java.util.List;

import com.esprit.dari.entities.LouerAchat.Sell;
import com.esprit.dari.entities.LouerAchat.rent;


public interface IAdSellService {

	public void AddBid(int idAd,Long idUser,int Price);
	public Sell AddSellAd(Sell S);
	public void DeleteSellAd(int i);
	public List<Sell> GetBidByAdId(int AdId);

}

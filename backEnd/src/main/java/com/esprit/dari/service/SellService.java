package com.esprit.dari.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.entities.Sell;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.entities.rent;
import tn.esprit.spring.repository.AdRepository;
import tn.esprit.spring.repository.SellAdRepository;
import tn.esprit.spring.repository.UserRepository;

@Service
public class SellService implements IAdSellService{

	@Autowired
	AdRepository AdR;
	@Autowired
	UserRepository UserR;
	@Autowired
	SellAdRepository SellR;
	
	
	@Override
	public Sell AddSellAd(Sell S){
         SellR.save(S);	
	     return S;
	}
	
	
	@Override 
	public void DeleteSellAd(int i){
		Sell S=SellR.findById(i).get();
		SellR.delete(S);
	}
	
	
	
	@Override
	public void AddBid(int idAd,int idUser,int Price){
		
		Ad A=AdR.findById(idAd).get();
		System.out.print("AAAAAAAAA"+A.getName());
		User Owner=A.getUser();
		User Buyer=UserR.findById(idUser).get();
		Date D = Calendar.getInstance().getTime();
		Sell S=new Sell();
		S.setAd_title(A.getName());
		S.setBidDate(D);
		S.setBidPrice(Price);
		S.setBuyerFirstName(Buyer.getFirstName());
		S.setBuyerLastName(Buyer.getLastName());
	    S.setOwnerFirstName(Owner.getFirstName());
	    S.setOwnerLastName(Owner.getLastName());
	    S.setAd_sell(A);
	    S.setUser_sell(Buyer);
	    AddSellAd(S);
	    
	}

	
	
}

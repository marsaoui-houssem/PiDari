package com.esprit.dari.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.RentContract;
import tn.esprit.spring.entities.Sell;
import tn.esprit.spring.entities.SellContract;
import tn.esprit.spring.entities.rent;
import tn.esprit.spring.repository.RentAdRepository;
import tn.esprit.spring.repository.RentContractRepository;
import tn.esprit.spring.repository.SellAdRepository;
import tn.esprit.spring.repository.SellContractRepository;


@Service
public class SellContractService implements ISellContractService{

	@Autowired
	SellAdRepository SellR;

	@Autowired
	SellContractRepository SellC;
	
	@Override
	public void Save(SellContract C){
		SellC.save(C);
	}
	
	@Override
	public void AddSellContract(String OwnerIdentityCard,String RenterIdentityCard,String ficheDePaie,String EngagementLetter,int Sellid)
	{
         SellContract RC=new SellContract();
 		 Date D = Calendar.getInstance().getTime();
         RC.setContractCreationDate(D);
         RC.setEngagementLetter(EngagementLetter);
         RC.setFicheDePaie(ficheDePaie);
         RC.setRenterIdentityCard(RenterIdentityCard);
         RC.setOwnerIdentityCard(OwnerIdentityCard);
         Sell S=SellR.findById(Sellid).get();
         RC.setSell(S);
         Save(RC);
	}
}

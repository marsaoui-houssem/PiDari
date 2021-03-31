package com.esprit.dari.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.RentContract;
import tn.esprit.spring.entities.rent;
import tn.esprit.spring.repository.RentAdRepository;
import tn.esprit.spring.repository.RentContractRepository;

@Service
public class RentContractService implements IRentContractService{

	@Autowired
	RentAdRepository RentR;

	@Autowired
	RentContractRepository RentC;
	
	@Override
	public void Save(RentContract C){
		RentC.save(C);
	}
	
	@Override
	public void AddRentContract(String OwnerIdentityCard,String RenterIdentityCard,String ficheDePaie,String EngagementLetter,int Rentid)
	{
         RentContract RC=new RentContract();
 		 Date D = Calendar.getInstance().getTime();
         RC.setContractCreationDate(D);
         RC.setEngagementLetter(EngagementLetter);
         RC.setFicheDePaie(ficheDePaie);
         RC.setOwnerIdentityCard(OwnerIdentityCard);
         rent r=RentR.findById(Rentid).get();
         RC.setRent(r);
         RC.setRenterIdentityCard(RenterIdentityCard);
	     Save(RC);
	}
}

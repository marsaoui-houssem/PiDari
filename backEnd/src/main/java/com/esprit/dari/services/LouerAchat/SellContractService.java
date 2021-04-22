package com.esprit.dari.services.LouerAchat;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.esprit.dari.dao.LouerAchat.SellAdRepository;
import com.esprit.dari.dao.LouerAchat.SellContractRepository;
import com.esprit.dari.entities.LouerAchat.Sell;
import com.esprit.dari.entities.LouerAchat.SellContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




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
	public void DeleteContractById(int ContractId){
		SellContract S=SellC.findById(ContractId).get();
		SellC.delete(S);
	}
	
	@Override
	public List<SellContract> GetAllContracts(){return (List<SellContract>) SellC.findAll();}

	
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

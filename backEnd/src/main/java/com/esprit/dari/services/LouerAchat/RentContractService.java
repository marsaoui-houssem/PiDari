package com.esprit.dari.services.LouerAchat;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.esprit.dari.dao.LouerAchat.RentAdRepository;
import com.esprit.dari.dao.LouerAchat.RentContractRepository;
import com.esprit.dari.entities.LouerAchat.RentContract;
import com.esprit.dari.entities.LouerAchat.rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     
	@Override
	public void DeleteContractById(int ContractId){
	    RentContract R=RentC.findById(ContractId).get();
		RentC.delete(R);
		}
   
	@Override	
	public List<RentContract> GetAllContracts(){return (List<RentContract>) RentC.findAll();}

	@Override
	public RentContract GetContractById(int ContractId){ 
		RentContract R=RentC.findById(ContractId).get();
		return R;}
}

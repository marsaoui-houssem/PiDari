package com.esprit.dari.services.LouerAchat;

import java.util.List;

import com.esprit.dari.entities.LouerAchat.RentContract;

public interface IRentContractService {

	public void AddRentContract(String OwnerIdentityCard,String RenterIdentityCard,String ficheDePaie,String EngagementLetter,int Rentid);
	public void Save(RentContract C);
	public void DeleteContractById(int ContractId);
	public List<RentContract> GetAllContracts();
	public RentContract GetContractById(int ContractId);
}

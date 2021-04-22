package com.esprit.dari.services.LouerAchat;


import com.esprit.dari.entities.LouerAchat.SellContract;

import java.util.List;

public interface ISellContractService {
	public void AddSellContract(String OwnerIdentityCard,String RenterIdentityCard,String ficheDePaie,String EngagementLetter,int Sellid);
	public void Save(SellContract C);
	public void DeleteContractById(int ContractId);
	public List<SellContract> GetAllContracts();

}

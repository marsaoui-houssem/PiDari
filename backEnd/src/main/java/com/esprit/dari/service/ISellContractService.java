package com.esprit.dari.service;

import tn.esprit.spring.entities.SellContract;

public interface ISellContractService {
	public void AddSellContract(String OwnerIdentityCard,String RenterIdentityCard,String ficheDePaie,String EngagementLetter,int Sellid);
	public void Save(SellContract C);

}

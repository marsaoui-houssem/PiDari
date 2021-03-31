package com.esprit.dari.service;

import tn.esprit.spring.entities.RentContract;

public interface IRentContractService {

	public void AddRentContract(String OwnerIdentityCard,String RenterIdentityCard,String ficheDePaie,String EngagementLetter,int Rentid);
	public void Save(RentContract C);



}

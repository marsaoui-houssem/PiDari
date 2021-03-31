package com.esprit.dari.service;
import tn.esprit.spring.entities.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.repository.DelegationRepository;
import tn.esprit.spring.repository.GovernorateRepository;

@Service
public class GovernorateService implements IGovernorateService{

	@Autowired
	GovernorateRepository GovRep;
	
	@Autowired
	DelegationRepository DelRep;
	
	
	public List<Delegation> getDelegationsByGovernorate(int GovId)
	{ 
		return GovRep.getDelegationsByGovernorate(GovId);
	}
  
	
    public float getMetrePricePerGovernorate(int GovId){
    	return GovRep.getMetrePricePerGovernorate(GovId);
    }
	
  	public List<Governorate> getAllGovernorates(){return (List<Governorate>) GovRep.findAll();}

	
}

package com.esprit.dari.services.LouerAchat;

import com.esprit.dari.dao.LouerAchat.DelegationRepository;
import com.esprit.dari.dao.LouerAchat.GovernorateRepository;
import com.esprit.dari.entities.LouerAchat.Delegation;
import com.esprit.dari.entities.LouerAchat.Governorate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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

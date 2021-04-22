package com.esprit.dari.services.LouerAchat;

import java.util.List;

import com.esprit.dari.entities.LouerAchat.Delegation;
import com.esprit.dari.entities.LouerAchat.Governorate;


public interface IGovernorateService {

	public List<Delegation> getDelegationsByGovernorate(int GovId);
    public float getMetrePricePerGovernorate(int GovId);
  	public List<Governorate> getAllGovernorates();
}

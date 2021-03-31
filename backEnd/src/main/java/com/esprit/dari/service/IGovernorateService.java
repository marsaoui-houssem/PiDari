package com.esprit.dari.service;

import java.util.List;

import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.entities.Delegation;
import tn.esprit.spring.entities.Governorate;

public interface IGovernorateService {

	public List<Delegation> getDelegationsByGovernorate(int GovId);
    public float getMetrePricePerGovernorate(int GovId);
  	public List<Governorate> getAllGovernorates();
}

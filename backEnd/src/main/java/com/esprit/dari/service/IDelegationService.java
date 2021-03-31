package com.esprit.dari.service;

import org.springframework.web.bind.annotation.PathVariable;

import tn.esprit.spring.entities.Delegation;

public interface IDelegationService {

    public int getMetrePricePerDelegation(int DelId);

	public Delegation AddDelegation(Delegation Del);
    
    public void setDelegationMetrePrice(int DelId,int PricePermetre);
}

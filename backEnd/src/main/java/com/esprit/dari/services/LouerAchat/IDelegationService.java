package com.esprit.dari.services.LouerAchat;

import com.esprit.dari.entities.LouerAchat.Delegation;
import org.springframework.web.bind.annotation.PathVariable;


public interface IDelegationService {

    public int getMetrePricePerDelegation(int DelId);

	public Delegation AddDelegation(Delegation Del);
    
    public void setDelegationMetrePrice(int DelId,int PricePermetre);
}

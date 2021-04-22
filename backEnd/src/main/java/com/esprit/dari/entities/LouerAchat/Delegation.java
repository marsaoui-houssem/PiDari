package com.esprit.dari.entities.LouerAchat;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Delegation {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String DelegationName;
	
	private int Pricepermetre;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JsonIgnore 
	private Governorate governorate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDelegationName() {
		return DelegationName;
	}

	public void setDelegationName(String delegationName) {
		DelegationName = delegationName;
	}

	public int getPricepermetre() {
		return Pricepermetre;
	}

	public void setPricepermetre(int pricepermetre) {
		Pricepermetre = pricepermetre;
	}

	public Governorate getGovernorate() {
		return governorate;
	}

	public void setGovernorate(Governorate governorate) {
		this.governorate = governorate;
	}

	public Delegation(String delegationName, int pricepermetre, Governorate governorate) {
		super();
		DelegationName = delegationName;
		Pricepermetre = pricepermetre;
		this.governorate = governorate;
	}

	public Delegation() {
		super();
	}

	
	
	
}

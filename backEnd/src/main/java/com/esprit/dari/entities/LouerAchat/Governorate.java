package com.esprit.dari.entities.LouerAchat;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Governorate {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String GovernorateName;
	
	
	@OneToMany(mappedBy="governorate",cascade={CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.LAZY)
	@JsonIgnore
	private Set<Delegation> Delegations= new HashSet<>();


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getGovernorateName() {
		return GovernorateName;
	}


	public void setGovernorateName(String governorateName) {
		GovernorateName = governorateName;
	}


	public Set<Delegation> getDelegations() {
		return Delegations;
	}


	public void setDelegations(Set<Delegation> delegations) {
		Delegations = delegations;
	}


	public Governorate(String governorateName, Set<Delegation> delegations) {
		super();
		GovernorateName = governorateName;
		Delegations = delegations;
	}


	public Governorate() {
		super();
	}
	
	
	
	
	}

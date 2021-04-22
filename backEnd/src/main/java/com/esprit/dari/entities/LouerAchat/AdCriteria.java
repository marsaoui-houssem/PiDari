package com.esprit.dari.entities.LouerAchat;

import com.esprit.dari.entities.AdAppointment.AdType;
import com.esprit.dari.entities.AdAppointment.Ad_Etat;

public class AdCriteria {

	private float minpricepermonth;
	
	private float maxpricepermonth;
	
	private float maxpriceperday;
	
	private float minpriceperday;
	
	private float priceperday;

	private String Governorate;
	
	private String Delegation;

	private double Minsurface;
	
	private double Maxsurface;
	
	private int rooms;
	
	private int nbrpieces;
	
	private Ad_Etat etat;
	
	private AdType type;
	
    private Boolean piscine;
    
    
	public float getMinpricepermonth() {
		return minpricepermonth;
	}

	public void setMinpricepermonth(float minpricepermonth) {
		this.minpricepermonth = minpricepermonth;
	}

	public float getMaxpricepermonth() {
		return maxpricepermonth;
	}

	public void setMaxpricepermonth(float maxpricepermonth) {
		this.maxpricepermonth = maxpricepermonth;
	}

	public float getMaxpriceperday() {
		return maxpriceperday;
	}

	public void setMaxpriceperday(float maxpriceperday) {
		this.maxpriceperday = maxpriceperday;
	}

	public float getMinpriceperday() {
		return minpriceperday;
	}

	public void setMinpriceperday(float minpriceperday) {
		this.minpriceperday = minpriceperday;
	}

	public float getPriceperday() {
		return priceperday;
	}

	public void setPriceperday(float priceperday) {
		this.priceperday = priceperday;
	}

	public String getGovernorate() {
		return Governorate;
	}

	public void setGovernorate(String governorate) {
		Governorate = governorate;
	}

	public String getDelegation() {
		return Delegation;
	}

	public void setDelegation(String delegation) {
		Delegation = delegation;
	}

	public double getMinsurface() {
		return Minsurface;
	}

	public void setMinsurface(double minsurface) {
		Minsurface = minsurface;
	}

	public double getMaxsurface() {
		return Maxsurface;
	}

	public void setMaxsurface(double maxsurface) {
		Maxsurface = maxsurface;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public int getNbrpieces() {
		return nbrpieces;
	}

	public void setNbrpieces(int nbrpieces) {
		this.nbrpieces = nbrpieces;
	}

	public Ad_Etat getEtat() {
		return etat;
	}

	public void setEtat(Ad_Etat etat) {
		this.etat = etat;
	}

	public AdType getType() {
		return type;
	}

	public void setType(AdType type) {
		this.type = type;
	}

	public Boolean getPiscine() {
		return piscine;
	}

	public void setPiscine(Boolean piscine) {
		this.piscine = piscine;
	}
	
	
	

}

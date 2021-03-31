package com.esprit.dari.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class SellContract {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String OwnerIdentityCard; 
	private Date ContractCreationDate;
	private String RenterIdentityCard;
	private String ficheDePaie;
	private String EngagementLetter;
	
	@OneToOne(mappedBy ="Contract")
    private Sell sell;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOwnerIdentityCard() {
		return OwnerIdentityCard;
	}

	public void setOwnerIdentityCard(String ownerIdentityCard) {
		OwnerIdentityCard = ownerIdentityCard;
	}

	public Date getContractCreationDate() {
		return ContractCreationDate;
	}

	public void setContractCreationDate(Date contractCreationDate) {
		ContractCreationDate = contractCreationDate;
	}

	public String getRenterIdentityCard() {
		return RenterIdentityCard;
	}

	public void setRenterIdentityCard(String renterIdentityCard) {
		RenterIdentityCard = renterIdentityCard;
	}

	public String getFicheDePaie() {
		return ficheDePaie;
	}

	public void setFicheDePaie(String ficheDePaie) {
		this.ficheDePaie = ficheDePaie;
	}

	public String getEngagementLetter() {
		return EngagementLetter;
	}

	public void setEngagementLetter(String engagementLetter) {
		EngagementLetter = engagementLetter;
	}

	public Sell getSell() {
		return sell;
	}

	public void setSell(Sell sell) {
		this.sell = sell;
	}

	public SellContract(String ownerIdentityCard, Date contractCreationDate, String renterIdentityCard,
			String ficheDePaie, String engagementLetter, Sell sell) {
		super();
		OwnerIdentityCard = ownerIdentityCard;
		ContractCreationDate = contractCreationDate;
		RenterIdentityCard = renterIdentityCard;
		this.ficheDePaie = ficheDePaie;
		EngagementLetter = engagementLetter;
		this.sell = sell;
	}

	public SellContract() {
		super();
	}
	
	
	
	
}

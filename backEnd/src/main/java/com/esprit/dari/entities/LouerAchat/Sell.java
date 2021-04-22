package com.esprit.dari.entities.LouerAchat;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.esprit.dari.entities.AdAppointment.Ad;
import com.esprit.dari.entities.userentity.UserDari;
import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class Sell {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String Ad_title;
	
	private float BidPrice ;
	
	private String OwnerLastName;
	
	private String OwnerFirstName;
	
	private String BuyerFirstName;
	
	private String BuyerLastName;

	@JsonFormat(pattern="yyyy-MM-dd")
	private Date BidDate;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="Contract_id", referencedColumnName = "id")
    private SellContract Contract;
	
	@ManyToOne(cascade=CascadeType.DETACH)
	private UserDari user_sell;
	
	@ManyToOne(cascade=CascadeType.DETACH)
	private Ad ad_sell;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAd_title() {
		return Ad_title;
	}

	public void setAd_title(String ad_title) {
		Ad_title = ad_title;
	}

	public float getBidPrice() {
		return BidPrice;
	}

	public void setBidPrice(float bidPrice) {
		BidPrice = bidPrice;
	}

	public String getOwnerLastName() {
		return OwnerLastName;
	}

	public void setOwnerLastName(String ownerLastName) {
		OwnerLastName = ownerLastName;
	}

	public String getOwnerFirstName() {
		return OwnerFirstName;
	}

	public void setOwnerFirstName(String ownerFirstName) {
		OwnerFirstName = ownerFirstName;
	}

	public String getBuyerFirstName() {
		return BuyerFirstName;
	}

	public void setBuyerFirstName(String buyerFirstName) {
		BuyerFirstName = buyerFirstName;
	}

	public String getBuyerLastName() {
		return BuyerLastName;
	}

	public void setBuyerLastName(String buyerLastName) {
		BuyerLastName = buyerLastName;
	}

	public Date getBidDate() {
		return BidDate;
	}

	public void setBidDate(Date bidDate) {
		BidDate = bidDate;
	}

	public SellContract getContract() {
		return Contract;
	}

	public void setContract(SellContract contract) {
		Contract = contract;
	}

	public UserDari getUser_sell() {
		return user_sell;
	}

	public void setUser_sell(UserDari user_sell) {
		this.user_sell = user_sell;
	}

	public Ad getAd_sell() {
		return ad_sell;
	}

	public void setAd_sell(Ad ad_sell) {
		this.ad_sell = ad_sell;
	}

	public Sell(String ad_title, float bidPrice, String ownerLastName, String ownerFirstName, String buyerFirstName,
			String buyerLastName, Date bidDate, SellContract contract, UserDari user_sell, Ad ad_sell) {
		super();
		Ad_title = ad_title;
		BidPrice = bidPrice;
		OwnerLastName = ownerLastName;
		OwnerFirstName = ownerFirstName;
		BuyerFirstName = buyerFirstName;
		BuyerLastName = buyerLastName;
		BidDate = bidDate;
		Contract = contract;
		this.user_sell = user_sell;
		this.ad_sell = ad_sell;
	}

	public Sell() {
		super();
	}

	
	
}

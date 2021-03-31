package com.esprit.dari.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.apache.http.annotation.Contract;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class rent {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String Ad_name;
	
	private String owner_first_name;
	private String owner_last_name;
	private String buyer_first_name;
	private String buyer_last_name;
	
	private float Total_Price;
	
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date Start_Date;
    
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date Finish_Date;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JsonIgnore
	private User user_rent;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JsonIgnore
	private Ad ad_rent;
    
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="Contract_id", referencedColumnName = "id")
    private RentContract Contract;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAd_name() {
		return Ad_name;
	}

	public void setAd_name(String ad_name) {
		Ad_name = ad_name;
	}

	public String getOwner_first_name() {
		return owner_first_name;
	}

	public void setOwner_first_name(String owner_first_name) {
		this.owner_first_name = owner_first_name;
	}

	public String getOwner_last_name() {
		return owner_last_name;
	}

	public void setOwner_last_name(String owner_last_name) {
		this.owner_last_name = owner_last_name;
	}

	public String getBuyer_first_name() {
		return buyer_first_name;
	}

	public void setBuyer_first_name(String buyer_first_name) {
		this.buyer_first_name = buyer_first_name;
	}

	public String getBuyer_last_name() {
		return buyer_last_name;
	}

	public void setBuyer_last_name(String buyer_last_name) {
		this.buyer_last_name = buyer_last_name;
	}

	public float getTotal_Price() {
		return Total_Price;
	}

	public void setTotal_Price(float total_Price) {
		Total_Price = total_Price;
	}

	public Date getStart_Date() {
		return Start_Date;
	}

	public void setStart_Date(Date start_Date) {
		Start_Date = start_Date;
	}

	public Date getFinish_Date() {
		return Finish_Date;
	}

	public void setFinish_Date(Date finish_Date) {
		Finish_Date = finish_Date;
	}

	public User getUser_rent() {
		return user_rent;
	}

	public void setUser_rent(User user_rent) {
		this.user_rent = user_rent;
	}

	public Ad getAd_rent() {
		return ad_rent;
	}

	public void setAd_rent(Ad ad_rent) {
		this.ad_rent = ad_rent;
	}

	public RentContract getContract() {
		return Contract;
	}

	public void setContract(RentContract contract) {
		Contract = contract;
	}

	public rent(String ad_name, String owner_first_name, String owner_last_name, String buyer_first_name,
			String buyer_last_name, float total_Price, Date start_Date, Date finish_Date, User user_rent, Ad ad_rent,
			RentContract contract) {
		super();
		Ad_name = ad_name;
		this.owner_first_name = owner_first_name;
		this.owner_last_name = owner_last_name;
		this.buyer_first_name = buyer_first_name;
		this.buyer_last_name = buyer_last_name;
		Total_Price = total_Price;
		Start_Date = start_Date;
		Finish_Date = finish_Date;
		this.user_rent = user_rent;
		this.ad_rent = ad_rent;
		Contract = contract;
	}

	public rent() {
		super();
	}

	
	

	
	
	
}

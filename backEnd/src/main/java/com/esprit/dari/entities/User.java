package com.esprit.dari.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	private String firstName;
	
	private String LastName;
	
	private int feedenabled=1;
	
	  
	private  Date debBlocFeed;
	
    
	private  Date  finBlocFeed;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private List<Feedback> feedbacks;
	
	@Column(unique=true)
	private String email;
	
	@Column
	private String address; 
	
	@Column
	private String password;
	
	@Column
	private int phoneNumber;
	
	@OneToMany(mappedBy="user",cascade={CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.EAGER)
    private Set<Ad> ads = new HashSet<>();
	
	
	@OneToMany(mappedBy="user_sell",cascade={CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.EAGER)
	private Set<Sell> sell=new HashSet<>();

	@OneToMany(mappedBy="user_rent",cascade={CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.EAGER)
	private Set<rent> rent=new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public int getFeedenabled() {
		return feedenabled;
	}

	public void setFeedenabled(int feedenabled) {
		this.feedenabled = feedenabled;
	}

	public Date getDebBlocFeed() {
		return debBlocFeed;
	}

	public void setDebBlocFeed(Date debBlocFeed) {
		this.debBlocFeed = debBlocFeed;
	}

	public Date getFinBlocFeed() {
		return finBlocFeed;
	}

	public void setFinBlocFeed(Date finBlocFeed) {
		this.finBlocFeed = finBlocFeed;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Set<Ad> getAds() {
		return ads;
	}

	public void setAds(Set<Ad> ads) {
		this.ads = ads;
	}

	public Set<Sell> getSell() {
		return sell;
	}

	public void setSell(Set<Sell> sell) {
		this.sell = sell;
	}

	public Set<rent> getRent() {
		return rent;
	}

	public void setRent(Set<rent> rent) {
		this.rent = rent;
	}

	
	
	
	public User() {
		super();
	}

	public User(int id, String firstName, String lastName, List<tn.esprit.spring.entities.Feedback> feedbacks,
			String email, String address, String password, int phoneNumber, Set<Ad> ads, Set<Sell> sell,
			Set<tn.esprit.spring.entities.rent> rent) {
		super();
		this.id = id;
		this.firstName = firstName;
		LastName = lastName;
		this.feedbacks = feedbacks;
		this.email = email;
		this.address = address;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.ads = ads;
		this.sell = sell;
		this.rent = rent;
	}


    

    

}

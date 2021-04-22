package com.esprit.dari.entities.LouerAchat;

import com.esprit.dari.entities.AdAppointment.Ad;
import com.esprit.dari.entities.userentity.UserDari;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_FEEDBACK")
public class Feedback implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String review;
	private float note;
	private int flags=0 ;
	private boolean flagtreated = false ;
	@ManyToOne
	private UserDari userr;
	@ManyToOne
	private Ad ad;
	
	
	//=========================Getters and Setters =========================//
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public float getNote() {
		return note;
	}
	public void setNote(float note) {
		this.note = note;
	}
	
	
	
	public UserDari getUser() {
		return userr;
	}
	public void setCustomer(UserDari user) {
		this.userr = user;
	}
	
	
	public int getFlags() {
		return flags;
	}
	public void setFlags(int flags) {
		this.flags = flags;
	}
	public Ad getAd() {
		return ad;
	}
	public void setAd(Ad ad) {
		this.ad = ad;
	}
	
	public boolean isFlagtreated() {
		return flagtreated;
	}
	public void setFlagtreated(boolean flagtreated) {
		this.flagtreated = flagtreated;
	}
	//===========================================================================================
	@Override
	public String toString() {
		return "Feedback [id=" + id + ", review=" + review + ", Note=" + note + "]";
	}
	
	//=================================Constructor============================================
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Feedback(String review,float note, UserDari user, Ad ad) {
		super();
		this.review = review;
		this.note = note;
		this.userr = user;
		this.ad = ad;
	}
	public Feedback(String review, float note) {
		super();
		this.review = review;
		this.note = note;
	}
	public Feedback(String review, float note, int flags, boolean flagtreated, UserDari user, Ad ad) {
		super();
		this.review = review;
		this.note = note;
		this.flags = flags;
		this.flagtreated = flagtreated;
		this.userr = user;
		this.ad = ad;
	}
	public Feedback(int id, String review, float note, int flags, boolean flagtreated, UserDari user, Ad ad) {
		super();
		this.id = id;
		this.review = review;
		this.note = note;
		this.flags = flags;
		this.flagtreated = flagtreated;
		this.userr = user;
		this.ad = ad;
	}
	
	
	
}
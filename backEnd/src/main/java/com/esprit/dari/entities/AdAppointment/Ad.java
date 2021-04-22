package com.esprit.dari.entities.AdAppointment;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.esprit.dari.entities.LouerAchat.*;

import com.esprit.dari.entities.userentity.UserDari;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Ad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private float price_per_day;

    private float price_per_month;

    private float price;

    private String Governorate ;

    private String Delegation;


    private double surface;

    private int nbrpieces;

    private int rooms;

    private String image;


    private boolean piscine;

    private String description;

    private int taux_reduction ;


    @Enumerated(EnumType.STRING)
    private Ad_Etat etat;

    @Enumerated(EnumType.STRING)
    private AdType type;

    @JsonIgnore
    @ManyToOne
    private UserDari user;

     @OneToMany(mappedBy="ad_sell",cascade={CascadeType.PERSIST,CascadeType.ALL},fetch=FetchType.LAZY)
    @JsonIgnore
    private Set<Sell> sells= new HashSet<>();

    @OneToMany(mappedBy="ad_rent",cascade={CascadeType.PERSIST,CascadeType.ALL},fetch=FetchType.LAZY)
    @JsonIgnore
    private Set<rent> rents= new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy="ad")
    @JsonIgnore
    private List<Feedback> feedbacks;



    @JsonIgnore
    @OneToMany(cascade =CascadeType.ALL,mappedBy="ads",fetch=FetchType.LAZY)
    private Set<Appointment> app;

    @OneToMany(cascade =CascadeType.ALL,mappedBy="ads",fetch=FetchType.LAZY)
    @JsonIgnore
    private Set<AdFav> Fav;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice_per_day() {
        return price_per_day;
    }

    public void setPrice_per_day(float price_per_day) {
        this.price_per_day = price_per_day;
    }

    public float getPrice_per_month() {
        return price_per_month;
    }

    public void setPrice_per_month(float price_per_month) {
        this.price_per_month = price_per_month;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    public int getNbrpieces() {
        return nbrpieces;
    }

    public void setNbrpieces(int nbrpieces) {
        this.nbrpieces = nbrpieces;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public boolean isPiscine() {
        return piscine;
    }

    public void setPiscine(boolean piscine) {
        this.piscine = piscine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTaux_reduction() {
        return taux_reduction;
    }

    public void setTaux_reduction(int taux_reduction) {
        this.taux_reduction = taux_reduction;
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

    public UserDari getUser() {
        return user;
    }

    public void setUser(UserDari user) {
        this.user = user;
    }

    public Set<Sell> getSells() {
        return sells;
    }

    public void setSells(Set<Sell> sells) {
        this.sells = sells;
    }

    public Set<rent> getRents() {
        return rents;
    }

    public void setRents(Set<rent> rents) {
        this.rents = rents;
    }

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }


    public Set<Appointment> getApp() {
        return app;
    }

    public void setApp(Set<Appointment> app) {
        this.app = app;
    }

    public Set<AdFav> getFav() {
        return Fav;
    }

    public void setFav(Set<AdFav> fav) {
        Fav = fav;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public Ad(String name, float price_per_day, float price_per_month, float price, String governorate, String delegation, double surface, int nbrpieces, int rooms, String image, boolean piscine, String description, int taux_reduction, Ad_Etat etat, AdType type, UserDari user, Set<Sell> sells, Set<rent> rents, List<Feedback> feedbacks, Set<Appointment> app, Set<AdFav> fav) {
        this.name = name;
        this.price_per_day = price_per_day;
        this.price_per_month = price_per_month;
        this.price = price;
        Governorate = governorate;
        Delegation = delegation;
        this.surface = surface;
        this.nbrpieces = nbrpieces;
        this.rooms = rooms;
        this.image = image;
        this.piscine = piscine;
        this.description = description;
        this.taux_reduction = taux_reduction;
        this.etat = etat;
        this.type = type;
        this.user = user;
        this.sells = sells;
        this.rents = rents;
        this.feedbacks = feedbacks;
        this.app = app;
        Fav = fav;
    }

    public Ad() {
super();

    }
}
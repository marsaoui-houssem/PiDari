package com.esprit.dari.entities.AdAppointment;
import java.io.Serializable;
import java.util.Set;

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
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAd;

    private String name;

    private double price;

    private String region;

    private double surface;

    private int nbrpieces;

    private int rooms;

    private boolean piscine;

    private String description;

    @Enumerated(EnumType.STRING)
    private Ad_Etat etat;

    @Enumerated(EnumType.STRING)
    private AdType type;

    @JsonIgnore
    @ManyToOne
    private UserDari user;

    @JsonIgnore
    @OneToMany(cascade =CascadeType.ALL,mappedBy="ads",fetch=FetchType.LAZY)
    private Set<Appointment> app;

    @OneToMany(cascade =CascadeType.ALL,mappedBy="ads",fetch=FetchType.LAZY)
    @JsonIgnore

    private Set<AdFav> Fav;







// @OneToMany(mappedBy="ad",cascade={CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.EAGER)
   // private List<Sell> sells= new ArrayList<>();

    //@OneToMany(mappedBy="ad_sell",cascade={CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.EAGER)
   // private List<rent> rents= new ArrayList<>();

    public Long getIdAd() {
        return idAd;
    }

    public void setIdAd(Long idAd) {

        this.idAd = idAd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
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

    public Ad(Long idAd, String name, double price, String region, double surface, int nbrpieces, int rooms, boolean piscine, String description, Ad_Etat etat, AdType type, UserDari user, Set<Appointment> app) {
        this.idAd = idAd;
        this.name = name;
        this.price = price;
        this.region = region;
        this.surface = surface;
        this.nbrpieces = nbrpieces;
        this.rooms = rooms;
        this.piscine = piscine;
        this.description = description;
        this.etat = etat;
        this.type = type;
        this.user = user;
        this.app = app;
    }

    public Ad(String name, double price, String region, double surface, int nbrpieces, int rooms,
              boolean piscine, String description, Ad_Etat etat, AdType type, UserDari user) {
        super();

        this.name = name;
        this.price = price;
        this.region = region;
        this.surface = surface;
        this.nbrpieces = nbrpieces;
        this.rooms = rooms;
        this.piscine = piscine;
        this.description = description;
        this.etat = etat;
        this.type = type;
        this.user = user;

    }

    public Ad() {
        super();
    }



}
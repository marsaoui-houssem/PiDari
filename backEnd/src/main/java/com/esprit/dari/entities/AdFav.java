package com.esprit.dari.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class AdFav implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFav;

    @JsonIgnore
    @ManyToOne
    private UserDari user;


    @ManyToOne
    @JsonIgnore
    private Ad ads;

   // @OneToMany(mappedBy="ad",cascade={CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.EAGER)
   // private List<Sell> sells= new ArrayList<>();

    //@OneToMany(mappedBy="ad_sell",cascade={CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.EAGER)
   // private List<rent> rents= new ArrayList<>();

    public Long getIdFav() {
        return idFav;
    }

    public void setIdFav(Long idFav) {

        this.idFav = idFav;
    }

    public UserDari getUser() {
        return user;
    }

    public void setUser(UserDari user) {
        this.user = user;
    }

    public Ad getAds() {
        return ads;
    }

    public void setAds(Ad ads) {
        this.ads = ads;
    }

    public AdFav() {
        super();
    }

    public AdFav(Long idFav, UserDari user, Ad ads) {
        this.idFav = idFav;
        this.user = user;
        this.ads = ads;
    }
}
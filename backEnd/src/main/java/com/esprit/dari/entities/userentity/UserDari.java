package com.esprit.dari.entities.userentity;


import com.esprit.dari.entities.AdAppointment.Ad;
import com.esprit.dari.entities.AdAppointment.AdFav;
import com.esprit.dari.entities.AdAppointment.Appointment;
import com.esprit.dari.entities.AdAppointment.Notification;
import com.esprit.dari.entities.abonnement.Abonnement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
public class UserDari implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique = true)
    private String username;
   // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String firstName;
    private String lastName;
    private String PhoneNumber;
    private String email;
    private boolean activated;
    private String imageUrl;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<RoleDari> roleDaris =new ArrayList<>();

     
    @OneToMany(cascade = CascadeType.REMOVE , mappedBy = "userDariAbon")
    private List<Abonnement> abonnements = new ArrayList<>();




    




    @JsonIgnore
    @OneToMany(cascade =CascadeType.ALL,mappedBy="user",fetch=FetchType.LAZY)
    private Set<Ad> ads;

    @JsonIgnore
    @OneToMany(cascade =CascadeType.ALL,mappedBy="user",fetch=FetchType.LAZY)
    private Set<AdFav> adFav;

    @JsonIgnore
    @OneToMany(cascade =CascadeType.ALL,mappedBy="user",fetch=FetchType.LAZY)
    private Set<Appointment> app;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonIgnore
    private Set<Notification> notifications;





    public UserDari() {
    }


    public UserDari(Long userId, String username, String password, String firstName, String lastName, String email, boolean activated, String imageUrl, Collection<RoleDari> roleDaris) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.activated = activated;
        this.imageUrl = imageUrl;
        this.roleDaris = roleDaris;
    }

    public UserDari(Long userId, String username, String password,boolean activated ,Collection<RoleDari> roleDaris) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.activated = activated;
        this.roleDaris = roleDaris;
    }

    public UserDari(Long userId, String username, String password, String email,boolean activated, Collection<RoleDari> roleDaris) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.activated =activated;
        this.roleDaris = roleDaris;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }
    @JsonIgnore
    public String getPassword() {
        return password;
    }
    @JsonSetter
    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Collection<RoleDari> getRoleDaris() {
        return roleDaris;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }




    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
    public void setRoleDaris(Collection<RoleDari> roleDaris) {
        this.roleDaris = roleDaris;
    }


    public List<Abonnement> getAbonnements() {
        return abonnements;
    }

    public void setAbonnements(List<Abonnement> abonnements) {
        this.abonnements = abonnements;
    }

    public Set<Ad> getAds() {
        return ads;
    }

    public void setAds(Set<Ad> ads) {
        this.ads = ads;
    }

    public Set<AdFav> getAdFav() {
        return adFav;
    }

    public void setAdFav(Set<AdFav> adFav) {
        this.adFav = adFav;
    }

    public Set<Appointment> getApp() {
        return app;
    }

    public void setApp(Set<Appointment> app) {
        this.app = app;
    }

    public Set<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(Set<Notification> notifications) {
        this.notifications = notifications;
    }
}

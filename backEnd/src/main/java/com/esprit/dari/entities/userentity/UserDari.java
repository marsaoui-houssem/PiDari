package com.esprit.dari.entities.userentity;



import com.esprit.dari.entities.AdAppointment.Ad;
import com.esprit.dari.entities.AdAppointment.AdFav;
import com.esprit.dari.entities.AdAppointment.Appointment;
import com.esprit.dari.entities.AdAppointment.Notification;
import com.esprit.dari.entities.LouerAchat.Feedback;
import com.esprit.dari.entities.LouerAchat.Sell;
import com.esprit.dari.entities.LouerAchat.rent;
import com.esprit.dari.entities.abonnement.Abonnement;



import com.esprit.dari.entities.furnituresEntities.Basket;
import com.esprit.dari.entities.furnituresEntities.Command;
import com.esprit.dari.entities.furnituresEntities.GiftPoints;

import com.esprit.dari.entities.userentity.RoleDari;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


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
    /* Nadheeeeeem */
    private int feedenabled = 1;
    private Date debBlocFeed;
    private Date finBlocFeed;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userr")
    private List<Feedback> feedbacks;

    @OneToMany(mappedBy = "user_sell", cascade = {CascadeType.PERSIST, CascadeType.ALL}, fetch = FetchType.EAGER)
    private Set<Sell> sell = new HashSet<>();

    @OneToMany(mappedBy = "user_rent", cascade = {CascadeType.PERSIST, CascadeType.ALL}, fetch = FetchType.EAGER)
    private Set<rent> rent = new HashSet<>();

    /* OOOOOOOOOOOOOOOOOOOOOO */


    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "userDariAbon")
    private List<Abonnement> abonnements = new ArrayList<>();


    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Ad> ads;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private Set<AdFav> adFav;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Appointment> app;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonIgnore
    private Set<Notification> notifications;


    private String ville;


    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<RoleDari> roleDaris = new ArrayList<>();


    @JsonIgnore
    @OneToMany(mappedBy = "users", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<GiftPoints> giftPoints = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "users", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Basket> baskets = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "users", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Command> commands = new ArrayList<>();



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

    public UserDari(Long userId, String username, String password, boolean activated, Collection<RoleDari> roleDaris) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.activated = activated;
        this.roleDaris = roleDaris;
    }

    public UserDari(Long userId, String username, String password, String email, boolean activated, Collection<RoleDari> roleDaris) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.activated = activated;
        this.roleDaris = roleDaris;
    }


    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public List<GiftPoints> getGiftPoints() {
        return giftPoints;
    }

    public void setGiftPoints(List<GiftPoints> giftPoints) {
        this.giftPoints = giftPoints;
    }

    public List<Basket> getBaskets() {
        return baskets;
    }

    public void setBaskets(List<Basket> baskets) {
        this.baskets = baskets;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
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


}
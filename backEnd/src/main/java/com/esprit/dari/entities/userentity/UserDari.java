package com.esprit.dari.entities.userentity;




//import com.esprit.dari.entities.creditentitie.DemandeCredit;
import com.esprit.dari.entities.AdAppointment.Ad;
import com.esprit.dari.entities.AdAppointment.AdFav;
import com.esprit.dari.entities.AdAppointment.Appointment;
import com.esprit.dari.entities.AdAppointment.Notification;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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
    private String email;
    private boolean activated = false;
    private String imageUrl;
    private String activationKey;

   // @OneToMany(cascade = CascadeType.REMOVE , mappedBy = "userDari")
    //private Collection<DemandeCredit> listDemandeCredit = new ArrayList<>();
   @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<RoleDari> roleDaris =new ArrayList<>();

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

    public Set<Ad> getAds() {
        return ads;
    }

    public void setAds(Set<Ad> ads) {
        this.ads = ads;
    }

    public UserDari() {
    }



    public Set<AdFav> getAdFav() {
        return adFav;
    }

    public void setAdFav(Set<AdFav> adFav) {
        this.adFav = adFav;
    }

    public UserDari(Long userId, String username, String password, String firstName, String lastName, String email, boolean activated, String imageUrl, String activationKey, Collection<RoleDari> roleDaris) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.activated = activated;
        this.imageUrl = imageUrl;
        this.activationKey = activationKey;
        this.roleDaris = roleDaris;

    }

    public Set<Appointment> getApp() {
        return app;
    }

    public void setApp(Set<Appointment> app) {
        this.app = app;
    }

    public UserDari(Long userId, String username, String password, Collection<RoleDari> roleDaris) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.roleDaris = roleDaris;
    }

    public UserDari(Long userId, String username, String password, String email, Collection<RoleDari> roleDaris) {
        this.username = username;
        this.password = password;
        this.email = email;
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

    public String getActivationKey() {
        return activationKey;
    }

    public void setActivationKey(String activationKey) {
        this.activationKey = activationKey;
    }

    public Collection<RoleDari> getRoleDaris() {
        return roleDaris;
    }

    public void setRoleDaris(Collection<RoleDari> roleDaris) {
        this.roleDaris = roleDaris;
    }



    //public Collection<DemandeCredit> getListDemandeCredit() {
       // return listDemandeCredit;
    //}

    //public void setListDemandeCredit(Collection<DemandeCredit> listDemandeCredit) {
       // this.listDemandeCredit = listDemandeCredit;
    //}


    public Set<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(Set<Notification> notifications) {
        this.notifications = notifications;
    }

    public UserDari(Long userId, String username, String password, String firstName, String lastName, String email, boolean activated, String imageUrl, String activationKey, Collection<RoleDari> roleDaris, Set<Ad> ads) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.activated = activated;
        this.imageUrl = imageUrl;
        this.activationKey = activationKey;
        this.roleDaris = roleDaris;
        this.ads = ads;
    }


}

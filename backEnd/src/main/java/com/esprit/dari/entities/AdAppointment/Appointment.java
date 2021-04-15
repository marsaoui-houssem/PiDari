package com.esprit.dari.entities.AdAppointment;

import com.esprit.dari.entities.userentity.UserDari;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Set;

@Entity
public class Appointment implements Serializable {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdApp;

    @Column
    private String Title;
    @Column
    private String Description;
    @Column
    private Date dateOfAppointment;
    @Column
    private Time TimeOfAppointment;
    @Column
    private String AppointmentAdress;
    @Column
    private int StateAppointment;

    @JsonIgnore
    @ManyToOne
    private UserDari user;

    @JsonIgnore
    @ManyToOne
    private Ad ads;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appointment",fetch=FetchType.LAZY)
    private Set<Notification> notifications;

    public Appointment() {
    }

    public Set<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(Set<Notification> notifications) {
        this.notifications = notifications;
    }

    public Appointment(Long idApp, String title, String description, Date dateOfAppointment, Time timeOfAppointment, String appointmentAdress, int stateAppointment, UserDari user, Ad ads) {
        IdApp = idApp;
        Title = title;
        Description = description;
        this.dateOfAppointment = dateOfAppointment;
        TimeOfAppointment = timeOfAppointment;
        AppointmentAdress = appointmentAdress;
        StateAppointment = stateAppointment;
        this.user = user;

        this.ads = ads;
    }


    public UserDari getUser() {
        return user;
    }

    public void setUser(UserDari user) {
        this.user = user;
    }

    public Long getIdApp() {
        return IdApp;
    }

    public void setIdApp(Long id) {
        IdApp = IdApp;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Date getDateOfAppointment() {
        return dateOfAppointment;
    }

    public void setDateOfAppointment(Date dateOfAppointment) {
        this.dateOfAppointment = dateOfAppointment;
    }

    public Time getTimeOfAppointment() {
        return TimeOfAppointment;
    }

    public void setTimeOfAppointment(Time timeOfAppointment) {
        TimeOfAppointment = timeOfAppointment;
    }

    public String getAppointmentAdress() {
        return AppointmentAdress;
    }

    public void setAppointmentAdress(String appointmentAdress) {
        AppointmentAdress = appointmentAdress;
    }

    public int getStateAppointment() {
        return StateAppointment;
    }

    public void setStateAppointment(int stateAppointment) {
        StateAppointment = stateAppointment;
    }



    public Ad getAds() {
        return ads;
    }

    public void setAds(Ad ads) {
        this.ads = ads;
    }
}
